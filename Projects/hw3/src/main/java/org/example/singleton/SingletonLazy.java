package org.example.singleton;

/**
 * Singleton class - Lazy initialization
 */
public class SingletonLazy {

    private SingletonLazy() {}
    private static volatile SingletonLazy instance;

    public static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}