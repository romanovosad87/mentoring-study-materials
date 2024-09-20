package concurrency.racecondition;

import java.util.concurrent.atomic.AtomicLong;

public class DemoApp {
    private static AtomicLong counter = new AtomicLong(0);
    public static void main(String[] args) throws InterruptedException {


        Runnable runnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                increment();
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter);
    }

    private static void increment() {
        counter.incrementAndGet();
    }
}
