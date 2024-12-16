package coding1;

// Demonstrates coding1.Inheritance
class Parent {
    void display() {
        System.out.println("This is the coding1.Parent class.");
    }
}

class Child extends Parent {
    void show() {
        System.out.println("This is the coding1.Child class.");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Child child = new Child();
        child.display(); // Inherited method
        child.show();    // coding1.Child class method
    }
}

