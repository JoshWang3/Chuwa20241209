public class TernaryExample {
    public static void main(String[] args) {
        String name = null;
        String greeting = "Hello, " + (name != null ? name : "Guest");
        System.out.println(greeting);
    }
}
