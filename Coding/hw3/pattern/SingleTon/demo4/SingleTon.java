// Lazy Loading: double check

public class SingleTon {
    private SingleTon(){}

    private static volatile SingleTon instance; // volatile保证多线程的情况下也不会出现指令重排序

    public static SingleTon getInstance(){
        // First time check: If instace is not null, no need to acquire the lock, return the instance directly.
        if(instance == null) {
            synchronized (SingleTon.class) {
                // The second time check:
                if(instance == null) {
                    instance = new SingleTon();
                }
            }
        }

        return instance;
    }
}