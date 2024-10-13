package concurrency.mergeSort;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DemoApp {

    public static void main(String[] args) {
        int size = 5_000_000;
        List<Integer> list = generateIntList(size);
        measureTimeExecution(new SequentialMergeSortTask<>(list));
        measureTimeExecution(new MergeSortTaskOneFork<>(list));
        measureTimeExecution(new MergeSortTaskTwoFork<>(list));
    }

    private static <T extends RecursiveAction> void measureTimeExecution(T action) {
        long totalTime = 0;
        int repeats = 10;
        for (int j = 0; j < repeats; j++) {
            long start = System.currentTimeMillis();
            ForkJoinPool.commonPool().invoke(action);
            totalTime += System.currentTimeMillis() - start;
        }
        long averageTime = totalTime / repeats;
        System.out.println(action.getClass().getSimpleName() + " - " + averageTime + "ms");
    }

    public static List<Integer> generateIntList(int size) {
        return IntStream.generate(() -> ThreadLocalRandom.current().nextInt(size))
                .limit(size)
                .boxed()
                .collect(Collectors.toList());
    }
}
