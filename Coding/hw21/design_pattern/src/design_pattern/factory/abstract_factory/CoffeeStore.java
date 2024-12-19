package design_pattern.factory.abstract_factory;

public class CoffeeStore {
    private DessertFactory coffeeFactory;

    public void setCoffeeFactory(DessertFactory cf) {
        this.coffeeFactory = cf;
    }

    public Coffee orderCoffee() {
        Coffee coffee = coffeeFactory.produceCoffee();
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
