package builder;

public class Client {
    public static void main(String[] args) {
        // 1. 创建指挥者对象
        Director director = new Director(new MobileBuilder());
        // 2. 指挥者指挥建造者创建产品
        Bike bike = director.construct();
        // 3. 查看产品
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}
