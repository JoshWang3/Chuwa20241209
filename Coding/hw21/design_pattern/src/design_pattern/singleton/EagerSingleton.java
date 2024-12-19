package design_pattern.singleton;

import java.io.Serial;
import java.io.Serializable;

/**
 * Eager Singleton Example
 * Create when program start
 */
public class EagerSingleton implements Serializable {
    private EagerSingleton() {
    }

    private static EagerSingleton instance = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return instance;
    }

    // 反序列化会调用此方法
    @Serial
    public Object readResolve() {
        return EagerSingleton.instance;
    }

    public static void main(String[] args) {
        EagerSingleton es1 = EagerSingleton.getInstance();
        EagerSingleton es2 = EagerSingleton.getInstance();
        System.out.println(es1 == es2);
    }
}