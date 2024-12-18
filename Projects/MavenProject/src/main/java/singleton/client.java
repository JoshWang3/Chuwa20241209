package singleton;

public class client {
    public static void main(String[] args) {
        singleton_eager1 instance = singleton_eager1.getInstance();
        singleton_eager1 instance1 = singleton_eager1.getInstance();

        //check if instance and instance1 are same project
        System.out.print(instance == instance1);
    }
}
