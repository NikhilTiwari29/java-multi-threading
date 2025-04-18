package basicMultiThreading;

public class JoinThreadExample {
    public static void main(String[] args) {
        Thread threa1 = new Thread(() -> {
                for (int i = 0; i < 4; i++) {
                    System.out.println("Running Thread1: " + i);
                }
        });

        Thread threa2 = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("Running Thread2: " + i);
            }
        });

        threa1.start(); //join() makes the main thread wait until the thread t1 has finished its execution before continuing with the rest of the code.
        threa2.start(); //join() makes the main thread wait until the thread t12 has finished its execution before continuing with the rest of the code.

        try {
            threa1.join();
            threa2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Completed executing thread run");
    }
}
