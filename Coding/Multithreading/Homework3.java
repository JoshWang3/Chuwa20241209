// Homework 3: Exception handling for API calls
import java.util.concurrent.CompletableFuture;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class Homework3 {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        CompletableFuture<String> productsFuture = fetchDataWithFallback(client, "https://jsonplaceholder.typicode.com/posts");
        CompletableFuture<String> reviewsFuture = fetchDataWithFallback(client, "https://jsonplaceholder.typicode.com/comments");
        CompletableFuture<String> inventoryFuture = fetchDataWithFallback(client, "https://jsonplaceholder.typicode.com/users");

        CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture).thenRun(() -> {
            try {
                String products = productsFuture.get();
                String reviews = reviewsFuture.get();
                String inventory = inventoryFuture.get();

                System.out.println("Merged Data:");
                System.out.println("Products: " + products);
                System.out.println("Reviews: " + reviews);
                System.out.println("Inventory: " + inventory);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).join();
    }

    private static CompletableFuture<String> fetchDataWithFallback(HttpClient client, String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(ex -> {
                    System.err.println("Failed to fetch data from " + url + ": " + ex.getMessage());
                    return "Default data";
                });
    }
}
