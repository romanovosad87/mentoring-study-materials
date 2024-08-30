package reflection;

import lombok.SneakyThrows;

public class ApplicationContext {

    @SneakyThrows
    public ApplicationContext(String basePackage) {

    }

    public <T> T getBean(Class<T> beanType) {
       return null;
    }
}
