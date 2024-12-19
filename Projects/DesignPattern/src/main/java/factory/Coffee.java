package factory;

public abstract class Coffee {
    public abstract  String getName();

    public void addSugar() {
        System.out.println("Add Sugar");
    }

    public void addMilk() {
        System.out.println("Add Milk");
    }
}
