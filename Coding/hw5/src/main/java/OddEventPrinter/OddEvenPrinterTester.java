package OddEventPrinter;

class OddEvenPrinter {
    private boolean isOdd = true;

    public synchronized void printOdd(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + number);
        isOdd = false;
        notify();
    }

    public synchronized void printEven(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + number);
        isOdd = true;
        notify();
    }
}

public class OddEvenPrinterTester {
    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter();

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
