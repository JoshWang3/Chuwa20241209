package singleton;

// 懒汉式，类加载不会导致对象初始化,只有首次使用该对象时才会初始化
public class Singleton_lazy {
    // 1.*私有*构造方法
    private Singleton_lazy () {}

    // 2.在本类中创建本类对象, 但是不初始化赋值
    private static Singleton_lazy instance;

    // 3.提供一个公有的静态方法，让外界获取该对象
    public static Singleton_lazy getInstance() {
        // 判断是否为空，为空则创建对象
        if (instance == null) {
            instance = new Singleton_lazy();
        }
        return instance;
    }
}
