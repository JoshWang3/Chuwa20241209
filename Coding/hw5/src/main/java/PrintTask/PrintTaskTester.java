package PrintTask;

class PrintTask implements Runnable {
    private final int start;
    private final int end;

    public PrintTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

public class PrintTaskTester {
    public static void main(String[] args) {
        // Create three threads with different ranges
        Thread thread1 = new Thread(new PrintTask(1, 10), "Thread-0");
        Thread thread2 = new Thread(new PrintTask(11, 20), "Thread-2");
        Thread thread3 = new Thread(new PrintTask(21, 30), "Thread-1");

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
