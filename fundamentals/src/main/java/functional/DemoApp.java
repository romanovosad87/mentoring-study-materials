package functional;


import java.util.Comparator;
import java.util.function.Function;

public class DemoApp {
    public static void main(String[] args) {
        Account oldest = Account.generate(10).stream()
            .max(myComparing(Account::getAge))
            .orElseThrow();
        System.out.println(oldest);
    }
}
