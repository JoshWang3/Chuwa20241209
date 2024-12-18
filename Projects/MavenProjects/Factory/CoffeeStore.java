package Factory;

public class CoffeeStore {
    public Coffee orderCoffee(String type) {
        Coffee coffee = null;

        if ("americano".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        }

        if (coffee != null) {
            coffee.addMilk();
            coffee.addSugar();
        }

        return coffee;
    }
}

