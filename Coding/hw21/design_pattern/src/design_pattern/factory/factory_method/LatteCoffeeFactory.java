package design_pattern.factory.factory_method;

public class LatteCoffeeFactory implements CoffeeFactory {

    @Override
    public Coffee produceCoffee() {
        return new LatteCoffee();
    }
}
