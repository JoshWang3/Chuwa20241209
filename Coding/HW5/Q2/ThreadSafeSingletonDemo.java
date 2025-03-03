package Chuwa20241209.Coding.HW5.Q2;

public class ThreadSafeSingletonDemo {
    public static void main(String[] args) {
        ThreadSafeSingleton instance1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton instance2 = ThreadSafeSingleton.getInstance();

        System.out.println(instance1 == instance2);
    }
}
