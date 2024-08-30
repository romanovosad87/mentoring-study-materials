package reflection.service;

import reflection.annotations.Autowired;
import reflection.annotations.Component;

@Component
public class HelloService {

    @Autowired
    private MessageService messageService;

    public void say() {
        System.out.println("Hello");
        messageService.sing();
    }
}
