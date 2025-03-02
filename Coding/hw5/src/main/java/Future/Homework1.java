package Future;

import java.util.concurrent.CompletableFuture;

public class Homework1 {
    public static void main(String[] args) {
        int a = 5, b = 3;

        // Asynchronously calculate sum
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> a + b);
        // Asynchronously calculate product
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> a * b);

        // Combine and print results
        sumFuture.thenAccept(sum -> System.out.println("Sum: " + sum));
        productFuture.thenAccept(product -> System.out.println("Product: " + product));

        // Ensure program does not terminate immediately
        CompletableFuture.allOf(sumFuture, productFuture).join();
    }
}
