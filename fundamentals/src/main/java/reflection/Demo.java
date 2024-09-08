package reflection;


import lombok.SneakyThrows;
import reflection.service.HelloService;

public class Demo {


    @SneakyThrows
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext("reflection");
        HelloService helloService = context.getBean(HelloService.class);
        helloService.say();

    }
}
