package design_pattern.factory.config_factory;

public class Client {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.produceCoffee(String.valueOf(CoffeeType.AMERICAN));
        assert coffee != null;
        System.out.println(coffee.getCoffeeName());
    }
}
