public class TryCatchExample {
    public static void main(String[] args) {
        String name = null;

        try {
            System.out.println(name.toUpperCase());
        } catch (NullPointerException e) {
            System.out.println("Caught a NullPointerException!");
        }
    }
}
