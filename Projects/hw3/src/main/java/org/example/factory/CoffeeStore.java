package org.example.factory;

public class CoffeeStore {
    public Coffee orderCoffee(String type) {
        Coffee coffee = null;
        if (type.equals("american")) {
            coffee = new AmericanCoffee();
        } else if (type.equals("latte")) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("Sorry, the coffee type is not available");
        }

        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
