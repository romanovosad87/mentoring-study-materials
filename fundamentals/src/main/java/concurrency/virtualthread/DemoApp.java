package concurrency.virtualthread;

import lombok.SneakyThrows;

public class DemoApp {

    @SneakyThrows
    public static void main(String[] args) {
//            runBusinessLogic();
    }

    public static void sleep(long time) {
        try {
            System.out.println(Thread.currentThread());
            Thread.sleep(time);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public static void runBusinessLogic() {
        // fetch data from DB
        // send http request
        // send email
        Thread virtualThread = Thread.startVirtualThread(() -> {
            try {
                Thread.sleep(1000);
                log("After first sleep");

                log("Starting second sleep (1500ms)");
                Thread.sleep(1500);
                log("After second sleep");

                log("Starting third sleep (2000ms)");
                Thread.sleep(2000);
                log("After third sleep");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        virtualThread.join();
    }

    private static void log(String message) {
        System.out.println(message + " | " + Thread.currentThread());
    }
}
