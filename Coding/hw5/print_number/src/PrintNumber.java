import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumber {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(); // Shared ReentrantLock

        // Thread 1: Outputs numbers 1-10
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    Thread.sleep(50); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        });

        // Thread 2: Outputs numbers 11-20
        Thread thread2 = new Thread(() -> {
            for (int i = 11; i <= 20; i++) {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    Thread.sleep(50); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        });

        // Thread 3: Outputs numbers 21-22
        Thread thread3 = new Thread(() -> {
            for (int i = 21; i <= 22; i++) {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    Thread.sleep(50); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        });

        // Start all threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
