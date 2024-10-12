package functional;


import java.util.Comparator;
import java.util.function.Function;

public class DemoApp {
    public static void main(String[] args) {
        Account oldestAndLongestEmail = Account.generate(10).stream()
                .peek(System.out::println)
                .max(myThenComparing(myComparing(Account::getAge), Account::getEmail))
                .orElseThrow();
        System.out.println("-----------");
        System.out.println(oldestAndLongestEmail);
    }

    private static <T, R extends Comparable<? super R>> Comparator<T> myComparing(
            Function<? super T, ? extends R> function) {
        return (t1, t2) -> function.apply(t1).compareTo(function.apply(t2));
    }

}
