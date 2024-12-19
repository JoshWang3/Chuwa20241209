package vehicle;

public class Sedan extends Vehicle {
    public Sedan(String licensePlate, String color) {
        super(licensePlate, color, String.valueOf(VehicleType.SEDAN));
    }
}
