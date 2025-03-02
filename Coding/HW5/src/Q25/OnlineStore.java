package Q25;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlineStore {
    private static final Logger logger = Logger.getLogger(OnlineStore.class.getName());
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        CompletableFuture<String> productsFuture = CompletableFuture.supplyAsync(() -> fetchProducts())
                .exceptionally(ex -> handleException("products", ex));
        CompletableFuture<String> reviewsFuture = CompletableFuture.supplyAsync(() -> fetchReviews())
                .exceptionally(ex -> handleException("reviews", ex));
        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(() -> fetchInventory())
                .exceptionally(ex -> handleException("inventory", ex));

        CompletableFuture<Void> allOf = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        allOf.join();

        String products = productsFuture.get();
        String reviews = reviewsFuture.get();
        String inventory = inventoryFuture.get();

        System.out.println("Merged Data for Processing:");
        System.out.println("Products Data: " + products);
        System.out.println("Reviews Data: " + reviews);
        System.out.println("Inventory Data: " + inventory);
    }


    private static String handleException(String apiName, Throwable ex) {
        logger.log(Level.SEVERE, "Error fetching " + apiName + " data", ex);
        return apiName + " data is unavailable";
    }


    private static String fetchProducts() {
        simulateApiCallDelay();
        return "Product 1, Product 2, Product 3";
    }


    private static String fetchReviews() {
        simulateApiCallDelay();
        return "Review 1, Review 2, Review 3";
    }


    private static String fetchInventory() {
        simulateApiCallDelay();
        return "Inventory 1, Inventory 2, Inventory 3";
    }


    private static void simulateApiCallDelay() {
        try {
            // Simulate network latency with a random delay (1-3 seconds)
            Thread.sleep((long) (Math.random() * 2000) + 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
