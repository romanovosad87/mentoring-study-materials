package reflection.service;

import reflection.annotations.LoggingExecution;

public class GreetingService {

    @LoggingExecution
    public void greeting() {
        System.out.println("Greeting...");
    }


    public void greetingWithoutExecution() {
        System.out.println("Greeting without ... ");

    }
}
