package Chuwa20241209.Coding.HW5.Q25;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureIntegerOperation {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;

        // Create -> add
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return a + b;
        });

        // Create -> product
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return a * b;
        });

        // thenAccept: Print the results when complete
        sumFuture.thenAccept(sum -> System.out.println("Sum: " + sum));
        productFuture.thenAccept(product -> System.out.println("Product: " + product));
    }
}
