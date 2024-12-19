package design_pattern.factory.factory_method;

public abstract class Coffee {

    public void addSugar() {
        System.out.println("Add Sugar");
    }

    public void addMilk() {
        System.out.println("Add Milk");
    }

    public abstract String getCoffeeName();
}
