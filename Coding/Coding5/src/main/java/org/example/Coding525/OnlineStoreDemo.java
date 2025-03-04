package org.example.Coding525;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class OnlineStoreDemo {
    private static final String PRODUCTS_API = "https://jsonplaceholder.typicode.com/posts";
    private static final String REVIEWS_API = "https://jsonplaceholder.typicode.com/comments";
    private static final String INVENTORY_API = "https://jsonplaceholder.typicode.com/todos";

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
        fetchStoreData().thenAccept(storeData -> {
            System.out.println("Fetched " + storeData.products.size() + " products");
            System.out.println("Fetched " + storeData.reviews.size() + " reviews");
            System.out.println("Fetched " + storeData.inventory.size() + " inventory items");
        }).join();
    }

    public static CompletableFuture<StoreData> fetchStoreData() {
        CompletableFuture<List<Map<String, Object>>> productsFuture = fetchData(PRODUCTS_API);
        CompletableFuture<List<Map<String, Object>>> reviewsFuture = fetchData(REVIEWS_API);
        CompletableFuture<List<Map<String, Object>>> inventoryFuture = fetchData(INVENTORY_API);

        return CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture)
                .thenApply(v -> new StoreData(
                        productsFuture.join(),
                        reviewsFuture.join(),
                        inventoryFuture.join()
                ));
    }

    private static CompletableFuture<List<Map<String, Object>>> fetchData(String apiUrl) {
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
                throw new CompletionException(e);
            }
        });
    }
}