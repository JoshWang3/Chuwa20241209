import java.util.Optional;

public class AvoidNullExample {
    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable(getName());
        System.out.println(name.orElse("Default Name")); // Use default if null
    }

    public static String getName() {
        return null; // Simulate null return
    }
}
