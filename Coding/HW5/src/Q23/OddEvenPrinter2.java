package Q23;

public class OddEvenPrinter2 {
    public static void main(String[] args) {
        Printer2 printer = new Printer2();

        Thread oddThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i += 2) {
                    printer.printOdd(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "OddThread");

        Thread evenThread = new Thread(() -> {
            try {
                for (int i = 2; i <= 10; i += 2) {
                    printer.printEven(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "EvenThread");

        oddThread.start();
        evenThread.start();
    }

}
