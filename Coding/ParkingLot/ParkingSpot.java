class ParkingSpot {
    private String spotId;
    private ParkingSpotType type;
    private boolean isAvailable;
    private Vehicle currentVehicle;

    public ParkingSpot(String spotId, ParkingSpotType type) {
        this.spotId = spotId;
        this.type = type;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.isAvailable = false;
        this.currentVehicle = vehicle;
    }

    public void removeVehicle() {
        this.isAvailable = true;
        this.currentVehicle = null;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public String getSpotId() {
        return spotId;
    }
}
