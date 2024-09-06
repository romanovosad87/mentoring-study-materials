package reflection;

import reflection.service.HelloService;
import reflection.service.MessageService;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;


public class Demo {


    public static void main(String[] args) {

        ApplicationContext applicationContext = new ApplicationContext("reflection");

        HelloService helloService = applicationContext.getBean(HelloService.class);
        helloService.say();

        // 1.  .class

        // 2. getClass()

        // Class.forName("")
//
    }
}
