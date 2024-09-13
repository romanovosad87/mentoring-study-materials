package functional;

import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Data
@ToString
public class Account {
    private int age;
    private String email;

    public static List<Account> generate(int size) {
        var list = new ArrayList<Account>();
        for (int i = 0; i < size; i++) {
            var account = new Account();
            account.setAge(ThreadLocalRandom.current().nextInt(18, 60));
            String string = RandomStringUtils.random(5, 48, 122, true, true, null, new Random());
            account.setEmail(string + "@gmail.com");
            list.add(account);
        }
        return list;
    }
}
