package Chuwa20241209.Coding.HW5.Q2;

public class ThreadSafeSingleton {
    // Volatile - visibility in threads
    private static volatile ThreadSafeSingleton instance;

    // Private -  prevent instantiation
    private ThreadSafeSingleton() {
        System.out.println("Instance created");
    }
    // Public
    public static ThreadSafeSingleton getInstance() {
        // Thread-safe
        if (instance == null) { // First check
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) { // Second check
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
