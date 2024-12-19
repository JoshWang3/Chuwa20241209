package design_pattern.singleton;

/**
 * EagerSingleton with static block init
 */
public class EagerSingletonWithStatic {
    private EagerSingletonWithStatic() {
    }

    private static EagerSingletonWithStatic instance;

    // static
    static {
        instance = new EagerSingletonWithStatic();
    }

    public static EagerSingletonWithStatic getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        EagerSingletonWithStatic es1 = EagerSingletonWithStatic.getInstance();
        EagerSingletonWithStatic es2 = EagerSingletonWithStatic.getInstance();
        System.out.println(es1 == es2);
    }
}
