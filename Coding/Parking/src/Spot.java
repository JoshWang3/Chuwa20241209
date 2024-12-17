class Spot {
    private int spotId;
    private Vehicle vehicle;

    public Spot(int spotId) {
        this.spotId = spotId;
        this.vehicle = null;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean park(Vehicle vehicle) {
        if (isAvailable()) {
            this.vehicle = vehicle;
            return true;
        }
        return false;
    }

    public Vehicle leave() {
        Vehicle temp = vehicle;
        vehicle = null;
        return temp;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSpotId() {
        return spotId;
    }
}

