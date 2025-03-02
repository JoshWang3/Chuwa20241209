package coding1;

public class ParkingSpot {
    private final String spotType;
    private Vehicle currentVehicle;

    public ParkingSpot(String spotType) {
        this.spotType = spotType;
        this.currentVehicle = null;
    }

    public boolean isAvailable() {
        return currentVehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return isAvailable() && spotType.equals(vehicle.getType());
    }

    public void park(Vehicle vehicle) {
        if (canFitVehicle(vehicle)) {
            currentVehicle = vehicle;
        }
        else {
            throw new IllegalArgumentException("The vehicle cannot be parked in this spot");
        }
    }

    public void leave() {
        currentVehicle = null;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public String getSpotType() {
        return spotType;
    }
}
