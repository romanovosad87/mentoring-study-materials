package reflection.service;

import reflection.annotations.Autowired;
import reflection.annotations.Component;

@Component
public class MessageService {

    @Autowired
    private GreetingService greetingService;

    public void sing() {
        System.out.println("Singing ... ");
        greetingService.greeting();
    }
}
