package factory;

public abstract class Coffee {
    public abstract  String getName();
    //add sugar
    public void addSugar() {
        System.out.print("add sugar");
    }
    //add milk
    public void addMilk() {
        System.out.print("add milk");
    }
}
