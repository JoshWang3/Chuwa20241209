public class Client{
    public static void main(String[] args) {
        SingleTon instance = new SingleTon();
        SingleTon instance1 = new SingleTon();
        System.out.println(instance == instance1);
    }
}