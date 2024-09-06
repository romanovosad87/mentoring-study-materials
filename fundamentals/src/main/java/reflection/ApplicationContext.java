package reflection;

import lombok.SneakyThrows;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.reflections.Reflections;
import reflection.annotations.Autowired;
import reflection.annotations.Component;
import reflection.annotations.Logging;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ApplicationContext {
    private final Map<String, Object> beanMap = new HashMap<>();

    @SneakyThrows
    public ApplicationContext(String basePackage) {
        Reflections reflections = new Reflections(basePackage);
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Component.class);

        for (var clazz : classes) {
            Object beanInstance = autowiredProcessor(clazz);
            if (hasLoggingAnnotation(clazz)) {
                beanInstance = createProxy(beanInstance);
            }
            beanMap.put(clazz.getName(), beanInstance);
        }

        for (var entry : beanMap.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            if (hasLoggingAnnotation(clazz)) {
                beanMap.put(clazz.getName(), createProxy(clazz));
            }
        }
    }

    private boolean hasLoggingAnnotation(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Logging.class)) {
                return true;
            }
        }
        return false;
    }

    private Object createProxy(Object instance) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(instance.getClass());
        enhancer.setCallback(getMethodInterceptor(instance));
        return enhancer.create();
    }

    private MethodInterceptor getMethodInterceptor(Object originalInstance) {
        return (obj, method, args, proxy) -> {
            if (method.isAnnotationPresent(Logging.class)) {
                long start = System.nanoTime();
                Object result = method.invoke(originalInstance);
                long finish = System.nanoTime();
                long executionTime = finish - start;
                System.out.printf("Execution time of %s: %s ns%n", method.getName(), executionTime);
                return result;
            }
            return proxy.invokeSuper(obj, args);
        };
    }

    @SneakyThrows
    private Object autowiredProcessor(Class<?> clazz) {
        Object newInstance = beanMap.get(clazz.getName());
        if (newInstance == null) {
            newInstance = clazz.getDeclaredConstructor().newInstance();
        }
        Field[] fields = clazz.getDeclaredFields();
        for (var field : fields) {
            if (field.isAnnotationPresent(Autowired.class)) {
                Object obj = autowiredProcessor(field.getType());
                field.setAccessible(true);
                field.set(newInstance, obj);
            }
        }
        return newInstance;
    }

    @SneakyThrows
    private Object createBean(Class<?> clazz) {
        return clazz.getDeclaredConstructor().newInstance();
    }

    public <T> T getBean(Class<T> beanType) {
        return beanType.cast(beanMap.get(beanType.getName()));
    }
}
