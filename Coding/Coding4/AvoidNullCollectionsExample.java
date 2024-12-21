import java.util.Collections;
import java.util.List;

public class AvoidNullCollectionsExample {
    public static void main(String[] args) {
        List<String> items = getItems();
        System.out.println("Items count: " + items.size());
    }

    public static List<String> getItems() {
        return Collections.emptyList(); // Return an empty list
    }
}
