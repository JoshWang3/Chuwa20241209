package Q23;



public class OddEvenPrinter {

    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread oddThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i += 2) {
                    printer.printOdd(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread evenThread = new Thread(() -> {
            try {
                for (int i = 2; i <= 10; i += 2) {
                    printer.printEven(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
