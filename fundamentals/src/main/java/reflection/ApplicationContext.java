package reflection;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import reflection.annotations.Autowired;
import reflection.annotations.Component;

import java.lang.reflect.Field;
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
            Object newInstance = type.getDeclaredConstructor().newInstance();
            Field[] fields = type.getDeclaredFields();
            for (var field : fields) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    var fieldInstance = beanMap.get(field.getType().getName());
                    if (fieldInstance == null) {
                        fieldInstance = field.getType().getDeclaredConstructor().newInstance();
                    }
                    field.setAccessible(true);
                    field.set(newInstance, fieldInstance);
                }
            }
            beanMap.put(type.getName(), newInstance);
        }
    }

    public <T> T getBean(Class<T> beanType) {
        String name = beanType.getName();
        return beanType.cast(beanMap.get(name));
    }
}
