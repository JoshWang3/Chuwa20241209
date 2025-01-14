package design_pattern.singleton;

public class LazySingleton {
    private static boolean flag = false;

    private LazySingleton() {
        synchronized (LazySingleton.class) {
            if (flag) {
                throw new RuntimeException("Cannot Create More Than One Object");
            }
            flag = true;
        }
    }
    private static LazySingleton instance;

    public static synchronized LazySingleton getInstance() {
        if (instance == null) instance = new LazySingleton();
        return instance;
    }

    public static void main(String[] args) {
        LazySingleton es1 = LazySingleton.getInstance();
        LazySingleton es2 = LazySingleton.getInstance();
        System.out.println(es1 == es2);
    }
}
