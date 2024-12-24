package reentrant_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinter {
    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock(); // Shared ReentrantLock
        Condition oddCondition = lock.newCondition();
        Condition evenCondition = lock.newCondition();

        // Odd number thread
        Thread oddThread = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 1; i <= 9; i += 2) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    evenCondition.signal(); // Signal the even thread to proceed
                    if (i != 9) { // Avoid waiting after the last number
                        oddCondition.await(); // Wait for the even thread
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        });

        // Even number thread
        Thread evenThread = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 2; i <= 10; i += 2) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    oddCondition.signal(); // Signal the odd thread to proceed
                    if (i != 10) { // Avoid waiting after the last number
                        evenCondition.await(); // Wait for the odd thread
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        });

        // Start the threads
        oddThread.start();
        evenThread.start();
    }
}
