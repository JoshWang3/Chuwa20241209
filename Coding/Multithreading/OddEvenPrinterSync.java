public class OddEvenPrinterSync {
    private static final Object lock = new Object();
    private static boolean isOddTurn = true;

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 9; i += 2) {
                synchronized (lock) {
                    while (!isOddTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    isOddTurn = false;
                    lock.notifyAll();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                synchronized (lock) {
                    while (isOddTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    isOddTurn = true;
                    lock.notifyAll();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
