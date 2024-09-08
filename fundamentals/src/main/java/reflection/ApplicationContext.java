package reflection;

import lombok.SneakyThrows;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.reflections.Reflections;
import reflection.annotations.Autowired;
import reflection.annotations.Component;
import reflection.annotations.LoggingExecution;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ApplicationContext {
    Map<String, Object> beanMap = new HashMap<>();

    @SneakyThrows
    public ApplicationContext(String basePackage) {
        Reflections reflections = new Reflections(basePackage);
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Component.class);
        for (var type : typesAnnotatedWith) {
            var newInstance = autowiredProcessor(type);
            beanMap.put(type.getName(), newInstance);
        }

        for (var entry : beanMap.entrySet()) {
            loggingProcessor(entry.getValue());
        }
    }

    private void loggingProcessor(Object instance) {
        Class<?> instanceClass = instance.getClass();
        Method[] methods = instanceClass.getDeclaredMethods();
        for (var method : methods) {
            if (method.isAnnotationPresent(LoggingExecution.class)) {
                Object proxy = createProxy(instance);
                beanMap.put(instanceClass.getName(), proxy);
            }
        }
    }

    private Object createProxy(Object instance) {
        var enhancer = new Enhancer();
        enhancer.setSuperclass(instance.getClass());
        enhancer.setCallback(loggingMethodInterceptor(instance));
        return enhancer.create();
    }

    private MethodInterceptor loggingMethodInterceptor(Object instance) {
        return (obj, method, args, proxy) -> {
            if (method.isAnnotationPresent(LoggingExecution.class)) {
                long start = System.nanoTime();
                Object invoked = method.invoke(instance);
                long finish = System.nanoTime();
                var execution = finish - start;
                System.out.println("Execution time of %s is %sns".formatted(method.getName(), execution));
                return invoked;
            }
            return proxy.invokeSuper(obj, args);
        };
    }

    @SneakyThrows
    private Object autowiredProcessor(Class<?> type) {
        Object newInstance = type.getDeclaredConstructor().newInstance();
        Field[] fields = type.getDeclaredFields();
        for (var field : fields) {
            if (field.isAnnotationPresent(Autowired.class)) {
                var fieldInstance = beanMap.get(field.getName());
                if (fieldInstance == null) {
                    fieldInstance = autowiredProcessor(field.getType());
                }
                field.setAccessible(true);
                field.set(newInstance, fieldInstance);
            }
        }
        return newInstance;
    }

    public <T> T getBean(Class<T> beanType) {
        String name = beanType.getName();
        return beanType.cast(beanMap.get(name));
    }
}
