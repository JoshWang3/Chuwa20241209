import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> name = getName();
        name.ifPresentOrElse(
            n -> System.out.println("Name: " + n),
            () -> System.out.println("No name provided")
        );
    }

    public static Optional<String> getName() {
        return Optional.empty(); // Simulates a missing value
    }
}
