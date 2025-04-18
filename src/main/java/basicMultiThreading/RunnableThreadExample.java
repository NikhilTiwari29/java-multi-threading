package basicMultiThreading;

public class RunnableThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());

        //using anonymous Runnable interface
        Thread thread3 = new Thread(() -> {
                for (int i = 0; i < 4; i++) {
                    System.out.println("Running Thread3: " + i);
                }
            }
        );

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Thread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Running Thread1: " + i);
        }
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Running Thread2: " + i);
        }
    }
}

