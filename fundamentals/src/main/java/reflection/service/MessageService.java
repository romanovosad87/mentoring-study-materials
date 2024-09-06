package reflection.service;

import reflection.annotations.Component;
import reflection.annotations.Logging;

@Component
public class MessageService {


    @Logging
    public void sing() {
        System.out.println("Singing ... ");
    }
}
