package singleton;

public class singleton_lazy2 {
    private singleton_lazy2() {}
    private static singleton_lazy2 instance;

    public static synchronized singleton_lazy2 getInstance() {
        if (instance == null) {
            instance = new singleton_lazy2();
        }
        return instance;
    }
}
