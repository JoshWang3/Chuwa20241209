package singleton;

public class singleton_eager2 {
    // private constructor
    private singleton_eager2() {}
    private static singleton_eager2 instance; // null

    static {
        instance = new singleton_eager2();
    }

    public static singleton_eager2 getInstance() {
        return instance;
    }
}
