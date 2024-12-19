package factory;

public class Client {
    public static void main(String[] args) {
        // create coffee store
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("latte");

        System.out.println(coffee.getName());

    }
}
