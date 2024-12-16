package Chuwa20241209.Coding.HW2.hw20.Inheritance;

class Vehicle {
    protected String brand;
    protected int price = 500;

    public int getPrice() {
        System.out.println("The parent price is: " + price);
        return price;
    }

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void start() {
        System.out.println("Vehicle started.");
    }
}

class Car extends Vehicle {
    protected int price = 250;
    public Car(String brand) {
        super(brand);
    }

    @Override
    public void start() {
        System.out.println("Car started.");
    }

    public void honk() {
        System.out.println("Car honking.");
    }
    public void printParentName() {
        System.out.println(super.price);
    }
}

public class CarBuilder {
    public static void main(String[] args) {
        Car myCar = new Car("Ford");
        System.out.println(myCar.brand);
        System.out.println(myCar.price);
        myCar.printParentName(); // super refer parent class attribute
        myCar.getPrice(); // getter from parent method
        myCar.start(); // Inherited from Vehicle method
        myCar.honk();  // Car’s own method
    }

}
