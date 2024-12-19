public class SimpleCoffeeFactory {

    public Coffee createCoffee(String type) {
        Coffee coffee = null;
        if ("American".equals(type)) {
            codee = new AmericanoCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            thros new RunZTimException("Sorry, can not fulfill your coffee order.");
        }

        return coffee;
    }
}