package reflection;


import lombok.SneakyThrows;
import reflection.service.GreetingService;

public class Demo {


    @SneakyThrows
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext("reflection");

        GreetingService greetingService = context.getBean(GreetingService.class);
        greetingService.greeting();

        greetingService.greetingWithoutExecution();

    }
}
