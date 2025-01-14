package vehicle;

public abstract class Vehicle {
    private String licensePlate;
    private String color;
    private String type;

    public Vehicle(String licensePlate, String color, String type) {
        this.licensePlate = licensePlate;
        this.color = color;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
    public String getColor() {
        return color;
    }
    public String getType() {
        return type;
    }
}
