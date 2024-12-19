package Chuwa20241209.MavenProject.DesignPattern.Factory;

public class CoffeeStore {
    public Coffee orderCoffee(String type) {

        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();

        Coffee coffee = factory.createCoffee(type);

        coffee.addMilk();
        coffee.addsugar();

        return coffee;
    }
}
