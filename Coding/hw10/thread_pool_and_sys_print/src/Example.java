import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            final int threadNumber = i;
            executorService.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.print("Thread: " + threadNumber + "---" + j + ", ");
                }

                System.out.println();
            });
        }
    }
}
