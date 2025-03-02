package OddEventPrinter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class OddEvenPrinterLock {
    private boolean isOdd = true;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void printOdd(int number) {
        lock.lock();
        try {
            while (!isOdd) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + ": " + number);
            isOdd = false;
            condition.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void printEven(int number) {
        lock.lock();
        try {
            while (isOdd) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + ": " + number);
            isOdd = true;
            condition.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}

public class MainLock {
    public static void main(String[] args) {
        OddEvenPrinterLock printer = new OddEvenPrinterLock();

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 9; i += 2) {
                printer.printOdd(i);
            }
        }, "Thread-0");

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                printer.printEven(i);
            }
        }, "Thread-1");

        oddThread.start();
        evenThread.start();
    }
}
