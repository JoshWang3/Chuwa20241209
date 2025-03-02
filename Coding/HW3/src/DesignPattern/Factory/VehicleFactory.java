package DesignPattern.Factory;

public class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if ("Car".equalsIgnoreCase(type)) {
            return new Car();
        } else if ("Bike".equalsIgnoreCase(type)) {
            return new Bike();
        }
        throw new IllegalArgumentException("Unknown vehicle type: " + type);
    }
}
