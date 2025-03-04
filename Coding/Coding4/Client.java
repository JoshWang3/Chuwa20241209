import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Use MyStream to filter and map data
        List<String> result = MyStream.of(names)
                                      .filter(name -> name.length() > 3)  // Keep names longer than 3 characters
                                      .map(String::toUpperCase)          // Convert names to uppercase
                                      .collect();                        // Collect results into a List

        System.out.println("Result: " + result); // Output: [ALICE, CHARLIE, DAVID]
    }
}
