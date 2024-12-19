public class Singleton2{

    private Singleton2() {}

    private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return instance;
    }

}