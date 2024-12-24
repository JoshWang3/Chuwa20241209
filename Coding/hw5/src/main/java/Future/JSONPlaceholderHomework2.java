package Future;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class JSONPlaceholderHomework2 {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public static void main(String[] args) {
        // Asynchronously fetch data from JSONPlaceholder API
        CompletableFuture<String> postsFuture = fetchFromApi("https://jsonplaceholder.typicode.com/posts");
        CompletableFuture<String> commentsFuture = fetchFromApi("https://jsonplaceholder.typicode.com/comments");
        CompletableFuture<String> usersFuture = fetchFromApi("https://jsonplaceholder.typicode.com/users");

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
