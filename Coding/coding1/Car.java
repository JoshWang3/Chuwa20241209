package coding1;

public class Car extends Vehicle {
    // The constructor of the Car class calls the constructor of the Vehicle class
    public Car(String licensePlate) {
        super(licensePlate, "Car");
    }
}
