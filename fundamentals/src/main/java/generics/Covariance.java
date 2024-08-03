package generics;

import java.util.ArrayList;
import java.util.List;

public class Covariance {
    public static void main(String[] args) {
        Number number;
        Integer integer = 1;
        number = integer;


        List<Number> numberList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();


    }

    public static void test(List<Number> list) {
    }
}
