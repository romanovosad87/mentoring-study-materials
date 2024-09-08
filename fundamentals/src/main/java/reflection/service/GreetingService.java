package reflection.service;

import reflection.annotations.Autowired;
import reflection.annotations.Component;

@Component
public class GreetingService {

    @Autowired
    private SmileService smileService;

    public void greeting() {
        System.out.println("Greeting ...");
        smileService.smile();
    }
}
