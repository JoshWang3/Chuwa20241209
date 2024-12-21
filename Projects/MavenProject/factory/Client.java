package factory;

public class Client {
    public static void main(String[] args) {
        // 1. 创建咖啡店对象
        CoffeeStore store = new CoffeeStore();
        // 2. 点咖啡
        Coffee coffee = store.orderCoffee("Latte");

        System.out.println(coffee.getName());
    }
}
