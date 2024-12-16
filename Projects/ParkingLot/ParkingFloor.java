// ParkingFloor class representing a floor in the parking lot
class ParkingFloor {
    private List<ParkingSpot> spots;

    // Constructors
    public ParkingFloor() {
        this.spots = new ArrayList<>();
    }

    // Getters and setters
    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void setSpots(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    // Member function
    public void addParkingSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    public void removeParkingSpot(ParkingSpot spot) {
        spots.remove(spot);
    }

    public int getNumberOfSpots() {
        return spots.size();
    }
}
