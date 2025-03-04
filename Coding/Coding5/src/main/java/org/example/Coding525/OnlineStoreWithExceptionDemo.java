package org.example.Coding525;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

public class OnlineStoreWithExceptionDemo {
    private static final String PRODUCTS_API = "https://jsonplaceholder.typicode.com/posts";
    private static final String REVIEWS_API = "https://jsonplaceholder.typicode.com/comments";
    private static final String INVENTORY_API = "https://jsonplaceholder.typicode.com/todos";
    private static final Logger logger = Logger.getLogger(OnlineStoreWithExceptionDemo.class.getName());

    static class StoreData {
        List<Map<String, Object>> products;
        List<Map<String, Object>> reviews;
        List<Map<String, Object>> inventory;

        public StoreData(List<Map<String, Object>> products,
                         List<Map<String, Object>> reviews,
                         List<Map<String, Object>> inventory) {
            this.products = products;
            this.reviews = reviews;
            this.inventory = inventory;
        }
    }

    public static void main(String[] args) {
        fetchStoreDataWithErrorHandling().thenAccept(storeData -> {
            System.out.println("Fetched " + storeData.products.size() + " products");
            System.out.println("Fetched " + storeData.reviews.size() + " reviews");
            System.out.println("Fetched " + storeData.inventory.size() + " inventory items");
        }).join();
    }

    public static CompletableFuture<StoreData> fetchStoreDataWithErrorHandling() {
        CompletableFuture<List<Map<String, Object>>> productsFuture =
                fetchDataWithFallback(PRODUCTS_API, "products");
        CompletableFuture<List<Map<String, Object>>> reviewsFuture =
                fetchDataWithFallback(REVIEWS_API, "reviews");
        CompletableFuture<List<Map<String, Object>>> inventoryFuture =
                fetchDataWithFallback(INVENTORY_API, "inventory");

        return CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture)
                .thenApply(v -> new StoreData(
                        productsFuture.join(),
                        reviewsFuture.join(),
                        inventoryFuture.join()
                ));
    }

    private static CompletableFuture<List<Map<String, Object>>> fetchDataWithFallback(
            String apiUrl, String dataType) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(apiUrl))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(response.body(),
                        new TypeReference<List<Map<String, Object>>>() {});
            } catch (Exception e) {
                logger.severe("Error fetching " + dataType + " data: " + e.getMessage());
                logger.severe("Stack trace: " + Arrays.toString(e.getStackTrace()));
                // Return empty list as fallback
                return new ArrayList<>();
            }
        });
    }
}