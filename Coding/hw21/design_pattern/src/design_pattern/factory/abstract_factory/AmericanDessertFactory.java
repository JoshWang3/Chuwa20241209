package design_pattern.factory.abstract_factory;

public class AmericanDessertFactory implements DessertFactory {
    @Override
    public Coffee produceCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert produceDessert() {
        return new MochaMusse();
    }
}
