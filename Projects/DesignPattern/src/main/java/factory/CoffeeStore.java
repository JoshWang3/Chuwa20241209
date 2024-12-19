package factory;

public class CoffeeStore {
    public Coffee orderCoffee(String type) {
        CoffeeFactory factory = new CoffeeFactory();

        Coffee coffee = factory.createCoffee(type);

        coffee.addSugar();
        coffee.addMilk();

        return coffee;
    }
}
