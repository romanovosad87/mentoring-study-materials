package concurrency.outdated;

public class DemoApp {
    public static volatile boolean needHelp = false;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            while (true) {
                if (needHelp) {
                    System.out.println("I am comming...");
                    needHelp = false;
                }
            }
        };

        new Thread(runnable).start();
        Thread.sleep(1000);
        needHelp = true;
    }
}
