package coding1;

public abstract class Vehicle {
    private final String licensePlate;
    private final String type;

    protected Vehicle(String licensePlate, String type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getType() {
        return type;
    }
}
