import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinterReentrantLock {
    private static final Lock lock = new ReentrantLock();
    private static final Condition oddTurn = lock.newCondition();
    private static final Condition evenTurn = lock.newCondition();
    private static boolean isOddTurn = true;

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 9; i += 2) {
                lock.lock();
                try {
                    while (!isOddTurn) {
                        oddTurn.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    isOddTurn = false;
                    evenTurn.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                lock.lock();
                try {
                    while (isOddTurn) {
                        evenTurn.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    isOddTurn = true;
                    oddTurn.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
