package Factory;

public abstract class Coffee {
    public abstract String getName();

    public void addMilk() {
        System.out.println("Adding milk...");
    }

    public void addSugar() {
        System.out.println("Adding sugar...");
    }
}

