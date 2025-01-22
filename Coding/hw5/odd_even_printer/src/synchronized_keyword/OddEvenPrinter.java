package synchronized_keyword;

public class OddEvenPrinter {

    public static void main(String[] args) {
        Object lock = new Object(); // Shared lock object

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    try {
                        lock.notify();  // Notify the other thread
                        if (i != 9) {
                            lock.wait(); // Wait for the other thread
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    try {
                        lock.notify(); // Notify the other thread
                        if (i != 10) {
                            lock.wait(); // Wait for the other thread
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
