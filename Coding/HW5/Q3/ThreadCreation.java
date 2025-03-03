package Chuwa20241209.Coding.HW5.Q3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread using extends Thread");
    }
}

class Thread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread using Runnable");
    }
}

public class ThreadCreation {
    public static void main(String[] args) {
        // Thread
        Thread1 t1 = new Thread1();
        t1.start();

        // Runnable
        Thread t2 = new Thread(new Thread2());
        t2.start();

        // Thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // multi Jobs -> thread pool (random choose)
        for (int i = 1; i <= 5; i++) {
            int jobId = i;
            executorService.submit(() -> {
                System.out.println("Job " + jobId + " is running on " + Thread.currentThread().getName());
            });
        }

        executorService.shutdown();
    }
}
