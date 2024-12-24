package Chuwa20241209.Coding.HW5.Q23;



public class OddEven_Intercommunication {
    private static final Object lock = new Object();
    private static boolean oddTurn = true;

    public static void main(String[] args) {

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 9; i += 2) {
                synchronized (lock) {
                    while (!oddTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(i);
                    oddTurn = false;
                    lock.notify();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                synchronized (lock) {
                    while (oddTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(i);
                    oddTurn = true;
                    lock.notify();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
