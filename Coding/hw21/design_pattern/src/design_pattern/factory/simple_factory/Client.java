package design_pattern.factory.simple_factory;

public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee(CoffeeType.LATTE.toString());
        System.out.println(coffee.getCoffeeName());
    }
}
