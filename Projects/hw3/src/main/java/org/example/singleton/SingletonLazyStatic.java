package org.example.singleton;

public class SingletonLazyStatic {

    private SingletonLazyStatic() {}

    private static class SingletonHolder {
        private static final SingletonLazyStatic INSTANCE = new SingletonLazyStatic();
    }

    public static SingletonLazyStatic getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
