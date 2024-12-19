package design_pattern.factory.simple_factory;

public class SimpleCoffeeFactory {

    public Coffee produceCoffee(String type) {
        Coffee coffee = null;
        if (CoffeeType.AMERICAN.toString().equals(type)) {
            coffee = new AmericanCoffee();
        } else if (CoffeeType.LATTE.toString().equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("Type not found");
        }

        return coffee;
    }
}
