package Chuwa20241209.MavenProject.DesignPattern.Factory;

public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type) {

        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("Coffee not available");
        }

        return coffee;
    }
}
