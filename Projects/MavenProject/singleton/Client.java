package singleton;

public class Client {
    public static void main(String[] args) {
        Singleton_eager instance = Singleton_eager.getInstance();
        Singleton_eager instance1 = Singleton_eager.getInstance();
        // 判断获取到的两个是否是同一个对象
        System.out.println(instance == instance1); // true, 保证只能创建一个对象

        Singleton_lazy instance2 = Singleton_lazy.getInstance();
        Singleton_lazy instance3 = Singleton_lazy.getInstance();
        // 判断获取到的两个是否是同一个对象
        System.out.println(instance2 == instance3); // true, 保证只能创建一个对象
    }
}
