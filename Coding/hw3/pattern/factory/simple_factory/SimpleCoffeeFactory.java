public class SimplecoffeeFactory {
    public Coffee createCoffee(String type) {
        Coffee coffee = null;

        if("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if("lattee".equals(type)) {
            coffee = new LatteeCoffee();
        } else {
            throw new RuntimeException("Sorry, the coffee you ordered is not existing.");
        }

        return coffee;
    }
}