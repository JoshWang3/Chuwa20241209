package Singleton;

public class EagerSingleton {
    // Create the single instance eagerly when the class is loaded
    private static final EagerSingleton instance = new EagerSingleton();

    // Private constructor to prevent instantiation from outside
    private EagerSingleton() {}

    // Public method to provide access to the singleton instance
    public static EagerSingleton getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Eager Singleton Instance");
    }

    // Main method to test the singleton
    public static void main(String[] args) {
        EagerSingleton singleton = EagerSingleton.getInstance();
        singleton.showMessage();
    }
}

