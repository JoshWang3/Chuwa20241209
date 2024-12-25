import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OnlineStore {
    HttpClient client;

    public OnlineStore() {
        client = HttpClient.newHttpClient();
    }

    public static void main(String[] args) {
        OnlineStore onlineStore = new OnlineStore();

        CompletableFuture<String> products = onlineStore.mockFetchData("https://jsonplaceholder.typicode.com/posts")
                .exceptionally(e -> {
                    System.err.println("Error fetching products: " + e.getMessage());
                    return "[]";
                });
        CompletableFuture<String> comments = onlineStore.mockFetchData("https://jsonplaceholder.typicode.com/comments")
                .exceptionally(e -> {
                    System.err.println("Error fetching comments: " + e.getMessage());
                    return "[]";
                });
        CompletableFuture<String> users = onlineStore.mockFetchData("https://jsonplaceholder.typicode.com/users")
                .exceptionally(e -> {
                    System.err.println("Error fetching users: " + e.getMessage());
                    return "[]";
                });

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(products, comments, users);

        allFutures.thenRun(() -> {
            try {
                String product = products.get(), comment = comments.get(), user = users.get();

                System.out.println("Products: " + product);
                System.out.println("Comments: " + comment);
                System.out.println("Users: " + user);
                System.out.println("Done");
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).join();

    }

    private CompletableFuture<String> mockFetchData(String url) {
        return CompletableFuture.supplyAsync(() -> {
           try {
               HttpRequest request = HttpRequest.newBuilder()
                       .uri(URI.create(url))
                       .GET()
                       .build();
               HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
               return response.body();
           } catch (Exception e) {
               e.printStackTrace();
           }
           return null;
        });
    }
}


