package design_pattern.factory.abstract_factory;

public class Client {
    public static void main(String[] args) {

        ItalyDessertFactory cf = new ItalyDessertFactory();
        Coffee coffee = cf.produceCoffee();
        Dessert dessert = cf.produceDessert();

        System.out.println(coffee.getCoffeeName());
        dessert.show();
    }
}
