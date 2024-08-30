package reflection;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Person {

    private String name;
    private int age;

    public void sayHello() {
        System.out.println("Hello");
    }
}
