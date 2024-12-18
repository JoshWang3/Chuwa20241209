package Singleton;

public class LazySingleton {
    // Declare the instance, volatile ensures visibility across threads
    private static volatile LazySingleton instance;

    // Private constructor to prevent instantiation from outside
    private LazySingleton() {}

    // Public method to provide access to the singleton instance with double-checked locking
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Lazy Singleton Instance");
    }

    // Main method to test the singleton
    public static void main(String[] args) {
        LazySingleton singleton = LazySingleton.getInstance();
        singleton.showMessage();
    }
}

