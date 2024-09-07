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
     * "name": "Bob",
     * "age": 30
     * }
     *
     * @param person
     * @return
     */
    @SneakyThrows
    public static String convertToJson(Object person) {
        StringBuilder builder = new StringBuilder("{\n");
        Class<?> personClass = person.getClass();
        Field[] fields = personClass.getDeclaredFields();
        for (var field : fields) {
            builder.append("\t");
            var name = field.getName();
            builder.append("\"").append(name).append("\"").append(": ");
            field.setAccessible(true);
            var value = field.get(person);
            Class<?> type = field.getType();
            if (type.equals(int.class)) {
                builder.append(value);
            } else {
                builder.append("\"").append(value).append("\"");
            }
            builder.append("\n");
        }
        builder.append("}");

        return builder.toString();
    }
}
