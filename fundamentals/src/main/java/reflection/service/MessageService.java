package reflection.service;

import reflection.annotations.Component;

@Component
public class MessageService {

    public void sing() {
        System.out.println("Singing ... ");
    }
}
