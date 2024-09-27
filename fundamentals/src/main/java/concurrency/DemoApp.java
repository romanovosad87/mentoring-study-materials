package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class DemoApp {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> integerList = new ArrayList<>(List.of(4, 3, 1, 5, 0, 2));
        ForkJoinPool.commonPool().invoke(new ParallelMergeSort(integerList));
        System.out.println(integerList);
    }
}
