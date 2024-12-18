package Factory;

public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();

        Coffee coffee1 = store.orderCoffee("americano");
        System.out.println("Ordered: " + coffee1.getName());

        Coffee coffee2 = store.orderCoffee("latte");
        System.out.println("Ordered: " + coffee2.getName());
    }
}

