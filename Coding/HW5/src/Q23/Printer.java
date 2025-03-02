package Q23;

public class Printer {
    private boolean isOdd = true;


    public synchronized void printOdd(int num) throws InterruptedException {
        while (!isOdd) {
            wait(); // Wait for the even thread to signal
        }
        System.out.println("Thread: " + Thread.currentThread().getName() + " - " + num);
        isOdd = false;
        notify();  // Notify the even thread
    }


    public synchronized void printEven(int num) throws InterruptedException {
        while (isOdd) {
            wait();  // Wait for the odd thread to signal
        }
        System.out.println("Thread: " + Thread.currentThread().getName() + " - " + num);
        isOdd = true;
        notify();  // Notify the odd thread
    }
}
