import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class SumAndProduct {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;
        BiFunction<Integer, Integer, Integer> product = (x, y) -> x * y;

        final int a = 1, b = 2;
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> sum.apply(a, b));
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> product.apply(a, b));

        CompletableFuture<Void> joinedFuture = CompletableFuture.allOf(sumFuture, productFuture);
        joinedFuture.thenAccept((v) -> {
            try {
                Integer sumRes = sumFuture.get();
                Integer productRes = productFuture.get();

                System.out.println("Sum Result: " + sumRes);
                System.out.println("Product Result: " + productRes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).join();
    }
}
