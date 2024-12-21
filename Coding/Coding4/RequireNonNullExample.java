import java.util.Objects;

public class RequireNonNullExample {
    public static void main(String[] args) {
        String name = null;
        try {
            greet(Objects.requireNonNull(name, "Name cannot be null!"));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void greet(String name) {
        System.out.println("Hello, " + name);
    }
}
