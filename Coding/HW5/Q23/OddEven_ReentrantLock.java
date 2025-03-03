package Chuwa20241209.Coding.HW5.Q23;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEven_ReentrantLock {
    // as a lock
    private static final Object monitor = new Object();
    private static int value = 1;

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable).start();// thread 1
        new Thread(runnable).start();// thread 2
    }

    static class PrintRunnable implements Runnable {
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();
        @Override
        public void run() {
            lock.lock();
            try   {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    condition.signalAll(); // signals the other thread to proceed
                    try {
                        condition.await(); // unlock -> to another thread, waits for its turn
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
