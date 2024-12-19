package design_pattern.factory.factory_method;

public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        store.setCoffeeFactory(new AmericanCoffeeFactory());
        Coffee coffee = store.orderCoffee();
        System.out.println(coffee.getCoffeeName());
    }
}
