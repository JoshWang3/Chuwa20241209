package org.example.singleton;


/**
 * Singleton class - Eager initialization - Static block
 */
public class SingletonStatic {

    private SingletonStatic() {}
    private static SingletonStatic instance;

    static {
        instance = new SingletonStatic();
    }
    public static SingletonStatic getInstance() {

        return instance;
    }
}