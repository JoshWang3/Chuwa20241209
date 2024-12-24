// Homework 1: Asynchronous computation of sum and product
import java.util.concurrent.CompletableFuture;

public class Homework1 {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> a + b);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> a * b);

        sumFuture.thenAccept(sum -> System.out.println("Sum: " + sum));
        productFuture.thenAccept(product -> System.out.println("Product: " + product));

        // Wait for completion
        CompletableFuture.allOf(sumFuture, productFuture).join();
    }
}