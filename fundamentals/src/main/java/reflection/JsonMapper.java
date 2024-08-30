package reflection;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class JsonMapper {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Bob");
        person.setAge(30);
        System.out.println(convertToJson(person));
    }

    /**
     * {
     *   "name": "Bob",
     *   "age": 30
     * }
     * @param person
     * @return
     */
    @SneakyThrows
    public static String convertToJson(Person person) {
        return "";

//        StringBuilder builder = new StringBuilder();
//        builder.append("{").append("\n");
//        builder.append("\t").append("\"").append("name").append("\"").append(": ").append("\"").append(person.getName()).append("\"");
//        builder.append("\n");
//        builder.append("\t").append("\"").append("age").append("\"").append(": ").append(person.getAge());
//        builder.append("\n");
//        builder.append("}");
//        return builder.toString();
    }
}
