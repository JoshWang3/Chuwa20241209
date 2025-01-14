package design_pattern.factory.simple_factory;

public class CoffeeStore {

    public Coffee orderCoffee(String type) {
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = factory.produceCoffee(type);
        coffee.addSugar();
        coffee.addMilk();

        return coffee;
    }
}
