package Chuwa20241209.Coding.HW5.Q25;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureOnlineStore {

    // fake API
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    // Helper method to fetch data from a specific endpoint
    private static CompletableFuture<String> fetchData(HttpClient httpClient, String endpoint, String defaultValue) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(ex -> {
                    System.err.println("Error fetching data from " + endpoint + ": " + ex.getMessage());
                    return defaultValue;
                });
    }

    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();

        // products
        CompletableFuture<String> productsFuture = fetchData(httpClient, "posts", "Default Products");

        // reviews
        CompletableFuture<String> reviewsFuture = fetchData(httpClient, "comments", "Default Reviews");

        // inventory
        CompletableFuture<String> inventoryFuture = fetchData(httpClient, "users", "Default Inventory");

        // Combine the fetched data
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(
                productsFuture, reviewsFuture, inventoryFuture
        ).thenRun(() -> {
            try {
                String products = productsFuture.get();
                String reviews = reviewsFuture.get();
                String inventory = inventoryFuture.get();

                System.out.println("Fetched Products Data:\n" + products.substring(0, 100) + "...\n");
                System.out.println("Fetched Reviews Data:\n" + reviews.substring(0, 100) + "...\n");
                System.out.println("Fetched Inventory Data:\n" + inventory.substring(0, 100) + "...\n");
            } catch (Exception e) {
                System.err.println("Error merging data: " + e.getMessage());
            }
        });
        // Wait all tasks to complete
        combinedFuture.join();
    }
}
