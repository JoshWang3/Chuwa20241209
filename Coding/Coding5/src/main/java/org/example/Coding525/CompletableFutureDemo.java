package org.example.Coding525;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculating sum on thread: " + Thread.currentThread().getName());
            return num1 + num2;
        });

        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculating product on thread: " + Thread.currentThread().getName());
            return num1 * num2;
        });

        sumFuture.thenAccept(sum -> System.out.println("Sum: " + sum));
        productFuture.thenAccept(product -> System.out.println("Product: " + product));

        // Wait for both operations to complete
        CompletableFuture.allOf(sumFuture, productFuture).join();
    }
}
