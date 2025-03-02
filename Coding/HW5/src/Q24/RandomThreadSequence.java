package Q24;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RandomThreadSequence {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(new PrinterTask(1, 10));
        executorService.submit(new PrinterTask(11, 20));
        executorService.submit(new PrinterTask(21, 30));

        executorService.shutdown();
    }
}
