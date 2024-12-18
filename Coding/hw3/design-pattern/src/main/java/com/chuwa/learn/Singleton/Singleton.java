package com.chuwa.learn.Singleton;

public class Singleton {
    // Private static instance, eagerly loaded or lazily loaded
    private static Singleton instance;

    // Private constructor to prevent instantiation
    private Singleton() {}

    // Public method to get the single instance (Lazy Initialization)
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) { // Thread safety
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Example method
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

