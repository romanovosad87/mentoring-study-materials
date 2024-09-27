package concurrency.threadlocal;

public class DemoApp {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {


        Thread firstThread = new Thread(() -> {
            threadLocal.set("first");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1: " + threadLocal.get());
        });

        Thread secondThread = new Thread(() -> {
            threadLocal.set("second");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2: " + threadLocal.get());
        });
        firstThread.start();
        secondThread.start();

    }
}
