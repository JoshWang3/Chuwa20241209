package Chuwa20241209.MavenProject.DesignPattern.Factory;

public class Client {
    public static void main(String[] args) {

        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("latte");

        System.out.println(coffee.getName());
    }
}
