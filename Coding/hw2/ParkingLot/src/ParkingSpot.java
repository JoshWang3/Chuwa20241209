public class ParkingSpot {
    private SpotType type;
    private boolean isOccupied;
    private Vehicle currentVehicle;

    public ParkingSpot(SpotType type) {
        this.type = type;
        this.isOccupied = false;
        this.currentVehicle = null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getType().ordinal() <= this.type.ordinal();
    }

    public boolean park(Vehicle vehicle) {
        if (!isOccupied && canFitVehicle(vehicle)) {
            this.currentVehicle = vehicle;
            this.isOccupied = true;
            return true;
        }
        return false;
    }

    public void unpark() {
        this.currentVehicle = null;
        this.isOccupied = false;
    }

    // Getter methods
    public SpotType getType() {
        return type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getCurrentVehicle() {  // 新增的 Getter 方法
        return currentVehicle;
    }
}
