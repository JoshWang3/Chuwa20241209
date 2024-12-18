package singleton;

public class singleton_eager1 {
    private singleton_eager1() {}

    private static singleton_eager1 instance = new singleton_eager1();

    public static singleton_eager1 getInstance() {
        return instance;
    }

}
