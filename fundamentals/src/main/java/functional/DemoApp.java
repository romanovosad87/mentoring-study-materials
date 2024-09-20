package functional;


public class DemoApp {
    public static void main(String[] args) {
        MyFunction<String, Integer> function = str -> str.length();
//        MyFunction<String, Integer> composeFunction = function.compose(str -> str.trim());
//        System.out.println(composeFunction.apply(" ab ")); // should return 2
    }


    interface MyFunction<T, R> {
        R apply(T element);
    }
}
