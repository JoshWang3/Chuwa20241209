package design_pattern.singleton;

public class LazySingletonThreadSafe {
    private LazySingletonThreadSafe() {
    }

    // volatile 可见性有序性保证
    private static volatile LazySingletonThreadSafe instance;

    public static LazySingletonThreadSafe getInstance() {
        if (instance == null) {
            synchronized (LazySingletonThreadSafe.class) {
                instance = new LazySingletonThreadSafe();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        LazySingletonThreadSafe es1 = LazySingletonThreadSafe.getInstance();
        LazySingletonThreadSafe es2 = LazySingletonThreadSafe.getInstance();
        System.out.println(es1 == es2);
    }
}
