package Singleton;

public class Singleton_eager {
    private Singleton_eager(){}

    private static Singleton_eager instance = new Singleton_eager();

    private static Singleton_eager getInstance(){
        return instance;
    }
}
