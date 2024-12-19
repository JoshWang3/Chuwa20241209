package org.example.singleton;

public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);

        SingletonStatic staticInstance = SingletonStatic.getInstance();
        SingletonStatic staticInstance2 = SingletonStatic.getInstance();
        System.out.println(staticInstance == staticInstance2);

        SingletonLazy lazyInstance = SingletonLazy.getInstance();
        SingletonLazy lazyInstance2 = SingletonLazy.getInstance();
        System.out.println(lazyInstance == lazyInstance2);

        SingletonLazyStatic lazyStaticInstance = SingletonLazyStatic.getInstance();
        SingletonLazyStatic lazyStaticInstance2 = SingletonLazyStatic.getInstance();
        System.out.println(lazyStaticInstance == lazyStaticInstance2);

        SingletonEnum enumInstance = SingletonEnum.INSTANCE;
        SingletonEnum enumInstance2 = SingletonEnum.INSTANCE;
        System.out.println(enumInstance == enumInstance2);
    }
}



