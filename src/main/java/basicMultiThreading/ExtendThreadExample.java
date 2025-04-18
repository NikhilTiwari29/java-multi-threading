package basicMultiThreading;

public class ExtendThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new ThreadExample1();
        Thread thread2 = new ThreadExample2();

        thread1.start();
        thread2.start();
    }
}

class ThreadExample1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Running Thread1: " + i);
        }
    }
}

class ThreadExample2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Running Thread2: " + i);
        }
    }
}
