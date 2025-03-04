public class NullCheckExample {
    public static void main(String[] args) {
        String name = null;

        if (name != null) {
            System.out.println("Name length: " + name.length());
        } else {
            System.out.println("Name is null!");
        }
    }
}
