package reflection.service;

import lombok.SneakyThrows;
import reflection.annotations.Autowired;
import reflection.annotations.Component;
import reflection.annotations.Logging;

@Component
public class HelloService {

    @Autowired
    private MessageService messageService;

    @Logging
    public void say() {
        System.out.println("Hello...");
        messageService.sing();
    }
}
