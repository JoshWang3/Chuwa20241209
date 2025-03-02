package factory;

public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type) {
        // 声明Coffee类型的变量，根据不同类型创建不同的Coffee子类对象
        Coffee coffee = null;
        if (type.equals("American")) {
            coffee = new AmericanCoffee();
        } else if (type.equals("Latte")) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("对不起，您所点的咖啡没有");
        }
        return coffee;
    }
}
