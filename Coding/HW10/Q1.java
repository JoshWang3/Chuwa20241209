package Chuwa20241209.Coding.HW10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.print(Thread.currentThread().getName() + " - " + i + " ");
            }
        };

        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);

        executorService.shutdown();
    }
}
