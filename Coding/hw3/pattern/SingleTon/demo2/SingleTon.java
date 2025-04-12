// Eager Load 2: static block
public class SingleTon {

    private SingleTon() {}

    private static SingleTon instance; // 直接声明变量

    static {
        instatnce = new SingleTon(); // 在static block里生成instance
    }

    public static SingleTon getInstance(){
        return instance;
    }
}

// Eager Load: may waste the memory
