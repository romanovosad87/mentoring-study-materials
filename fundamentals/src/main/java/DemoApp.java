import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoApp {
    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        List<Number> numberList1 = new ArrayList<>();
        Collections.copy(numberList, numberList1);

    }

}
