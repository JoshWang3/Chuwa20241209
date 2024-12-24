package Future;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class JSONPlaceholderHomework3 {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public static void main(String[] args) {
        // Asynchronously fetch data with exception handling
        CompletableFuture<String> postsFuture = fetchFromApi("https://jsonplaceholder.typicode.com/posts")
                .exceptionally(e -> {
                    System.err.println("Failed to fetch posts: " + e.getMessage());
                    return "Default Posts Data";
                });

        CompletableFuture<String> commentsFuture = fetchFromApi("https://jsonplaceholder.typicode.com/comments")
                .exceptionally(e -> {
                    System.err.println("Failed to fetch comments: " + e.getMessage());
                    return "Default Comments Data";
                });

        CompletableFuture<String> usersFuture = fetchFromApi("https://jsonplaceholder.typicode.com/users")
                .exceptionally(e -> {
                    System.err.println("Failed to fetch users: " + e.getMessage());
                    return "Default Users Data";
                });

        // Combine results
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(postsFuture, commentsFuture, usersFuture)
                .thenRun(() -> {
                    try {
                        System.out.println("Posts Data: " + postsFuture.get());
                        System.out.println("Comments Data: " + commentsFuture.get());
                        System.out.println("Users Data: " + usersFuture.get());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        // Wait for all tasks to complete
        combinedFuture.join();
    }

    private static CompletableFuture<String> fetchFromApi(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        return CLIENT.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }
}
