package reflection;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import reflection.annotations.Component;

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
            beanMap.put(type.getName(), newInstance);
        }
    }

    public <T> T getBean(Class<T> beanType) {
        String name = beanType.getName();
        return beanType.cast(beanMap.get(name));
    }
}
