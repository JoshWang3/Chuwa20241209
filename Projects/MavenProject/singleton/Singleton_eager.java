package singleton;

// 饿汉式，类加载时就初始化对象
public class Singleton_eager {
    // 1.*私有*构造方法
    private Singleton_eager () {}

    // 2.在本类中创建本类对象
    private static Singleton_eager instance = new Singleton_eager();

    // 3.提供一个公有的静态方法，让外界获取该对象
    public static Singleton_eager getInstance() {
        return instance;
    }

}
