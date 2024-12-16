package coding1;

// Demonstrates coding1.Encapsulation
public class Encapsulation {
    private String name; // Private field

    // Getter method
    public String getName() {
        return name;
    }

    // Setter method
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Encapsulation obj = new Encapsulation();
        obj.setName("John");
        System.out.println("Name: " + obj.getName());
    }
}
