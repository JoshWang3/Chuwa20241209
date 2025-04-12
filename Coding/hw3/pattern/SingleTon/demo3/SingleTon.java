// Lazy Loading:

public class SingleTon{
    private SingleTon(){};

    private static SingleTon instance;

    public static synchronized SingleTon getInstance() { // Adding Synchronized to achieve thread safety.
        if(instance == null) {
            // Thread1 is waitting, Thread2 get CPU.
            instance = new SingleTon(); // Without null check, each time it will creates a new instance.
        }

        return instance;
    }
}