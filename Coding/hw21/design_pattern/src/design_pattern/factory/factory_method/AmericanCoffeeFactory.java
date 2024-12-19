package design_pattern.factory.factory_method;

public class AmericanCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee produceCoffee() {
        return new AmericanCoffee();
    }
}
