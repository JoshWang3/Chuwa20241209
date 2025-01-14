package vehicle;

public class Truck extends Vehicle {
    public Truck(String licensePlate, String color) {
        super(licensePlate, color, String.valueOf(VehicleType.TRUCK));
    }
}
