package design_pattern.factory.factory_method;

public class CoffeeStore {
    private CoffeeFactory coffeeFactory;

    public void setCoffeeFactory(CoffeeFactory cf) {
        this.coffeeFactory = cf;
    }

    public Coffee orderCoffee() {
        Coffee coffee = coffeeFactory.produceCoffee();
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
