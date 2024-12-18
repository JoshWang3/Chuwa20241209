package singleton;

public class singleton_lazy3 {
    private singleton_lazy3() {}

    private static singleton_lazy3 instance;

    public static singleton_lazy3 getInstance() {
        if (instance == null) {
            synchronized (singleton_lazy3.class) {
                if (instance == null) {
                    instance = new singleton_lazy3();
                }
            }
        }
        return instance;
    }
}
