package org.example.singleton;


/**
 * Singleton class - Eager initialization
 */
public class Singleton {

    private Singleton() {}
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}

