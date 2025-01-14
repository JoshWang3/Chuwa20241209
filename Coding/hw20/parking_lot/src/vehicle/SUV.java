package vehicle;

public class SUV extends Vehicle {
    public SUV(String licensePlate, String color) {
        super(licensePlate, color, String.valueOf(VehicleType.SUV));
    }
}
