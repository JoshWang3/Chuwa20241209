package parkinglot;

public class ParkingSpot {
    private String id;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot(String id) {
        this.id = id;
        this.isOccupied = false;
    }

    public boolean park(Vehicle vehicle) {
        if (!isOccupied) {
            this.vehicle = vehicle;
            isOccupied = true;
            return true;
        }
        return false;
    }

    public Vehicle removeVehicle() {
        Vehicle temp = this.vehicle;
        this.vehicle = null;
        isOccupied = false;
        return temp;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}