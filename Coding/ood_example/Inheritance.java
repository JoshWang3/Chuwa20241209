public class InheritanceExample {
    public static void main(String[] args) {
        Shape shape = new Shape("Generic Shape");
        shape.displayInfo();

        Circle circle = new Circle("Circle", 5);
        circle.displayInfo();
        System.out.println("Area of circle: " + circle.calculateArea());
    }
}

class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("This is a " + name);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
