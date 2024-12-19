package Singleton;

public class Singleton_lazy {
    private Singleton_lazy() {

    }

    static {

    }

    private static class SingletonHolder {
        private static final Singleton_lazy INSTANCE = new Singleton_lazy();
    }

    public static Singleton_lazy getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
