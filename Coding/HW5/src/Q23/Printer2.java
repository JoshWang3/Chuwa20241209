package Q23;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Printer2 {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean isOdd = true;


    public void printOdd(int num) throws InterruptedException {
        lock.lock();
        try {
            while (!isOdd) {
                condition.await();  // Wait for the even thread to signal
            }
            System.out.println("Thread: " + Thread.currentThread().getName() + " - " + num);
            isOdd = false;
            condition.signal();  // Notify the even thread
        } finally {
            lock.unlock();
        }
    }

    public void printEven(int num) throws InterruptedException {
        lock.lock();
        try {
            while (isOdd) {
                condition.await();  // Wait for the odd thread to signal
            }
            System.out.println("Thread: " + Thread.currentThread().getName() + " - " + num);
            isOdd = true;
            condition.signal();  // Notify the odd thread
        } finally {
            lock.unlock();
        }
    }

}
