package singleton;

public class singleton_lazy1 {
    private singleton_lazy1() {}

    private static singleton_lazy1 instance;

    public static singleton_lazy1 getInstance() {
        if (instance == null) {
            instance = new singleton_lazy1();
        }
        return instance;
    }
}
