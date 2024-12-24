package Chuwa20241209.Coding.HW5.Q8;

public class Deadlock {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        // lock 1 -> 2
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Lock 1");
                try { Thread.sleep(200); } catch (InterruptedException e) {}
                synchronized (resource2) {
                    System.out.println("Thread 1: Lock 2");
                }
            }
        });

        // lock 2 -> 1
        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Lock 2");
                try { Thread.sleep(200); } catch (InterruptedException e) {}
                synchronized (resource1) {
                    System.out.println("Thread 2: Lock 1");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
