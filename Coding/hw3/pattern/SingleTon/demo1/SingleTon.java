
// Eager Load 1: static param

public class SingleTon {

    private SingleTon(){} // No semicolon needed after the constructor block.

    private static Singleton instance = new SingleTon(); // 直接声明变量的同时，直接生成instance

    public static SingleTon getInstance() {
        return instance;
    }
}

// Eager Load: may waste the memory

// // No semicolon needed after the constructor block.
// Semicolons are required for field declarations and method calls.