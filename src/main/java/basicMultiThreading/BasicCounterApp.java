package basicMultiThreading;

public class BasicCounterApp {

    static int counter = 0;

    //Thread 1: Increments the counter
    static class IncrementThread extends Thread{

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                counter++;
                System.out.println("IncrementThread: counter = " + counter);
            }
        }
    }

    // Thread 2: Prints the counter
    static class PrintThread implements Runnable{

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("PrintThread: counter = " + counter);
            }
        }
    }

    public static void main(String[] args) {
        IncrementThread incrementThread = new IncrementThread();
        Thread printThread = new Thread(new PrintThread());

        incrementThread.start(); // Start incrementing
        try {
            incrementThread.join(); // Wait for incrementThread to finish before printing
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        printThread.start(); //Start printing
        try {
            printThread.join(); // Wait for printThread to finish
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Both threads are done. Final counter = " + counter);
    }
}
