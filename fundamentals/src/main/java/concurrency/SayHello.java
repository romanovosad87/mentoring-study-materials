package concurrency;

public class SayHello {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Hello from " + Thread.currentThread().getName());
            }
        };
        thread.start();

        new Thread(() -> System.out.println("Hello from " + Thread.currentThread().getName())).start();

        MyThread myThread = new MyThread();
        myThread.start();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    }


}
