package reflection;


import lombok.SneakyThrows;
import reflection.service.HelloService;
import reflection.service.MessageService;

public class Demo {


    @SneakyThrows
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext("reflection");
        MessageService messageService = context.getBean(MessageService.class);
        messageService.sing();

//        // 1.  .class
//        Class<Person> personClass = Person.class;
//        Method[] methods = personClass.getDeclaredMethods();
//        Person person = personClass.getDeclaredConstructor().newInstance();
//        for (var method : methods) {
//            method.invoke(person);
//        }
//
//
//        // 2. getClass()
//        Person person1 = new Person();
//        Class<? extends Person> person1Class = person1.getClass();
//
//        // Class.forName("")
//        Class<?> person2Class = Class.forName("reflection.Person");
//        System.out.println(person2Class.getName());
//
    }
}
