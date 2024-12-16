// EntrancePanel class for vehicle entrance
class EntrancePanel {
    private ParkingLot parkingLot;
    private ParkingSpotManager spotManager;

    // Constructors
    public EntrancePanel(ParkingLot parkingLot, ParkingSpotManager spotManager) {
        this.parkingLot = parkingLot;
        this.spotManager = spotManager;
    }

    // Member function
    public ParkingTicket issueParkingTicket(Vehicle vehicle) {
        // Check if spotManager is not null before accessing its methods

        // Check if there are available spots in the parking lot

        // Generate ticket details and return the issued parking ticket

        // Return the issued parking ticket
    }

    // Helper method to check if the spot is compatible with the vehicle
    private boolean isCompatibleSpot(Vehicle vehicle, ParkingSpot spot) {
        if (spot instanceof MotorcycleSpot) {
            return vehicle instanceof Motorcycle;
        } else if (spot instanceof CompactSpot) {
            return vehicle instanceof Car;
        } else if (spot instanceof LargeSpot) {
            return true; // Large spots allow any type of vehicle
        }
        return false;
    }

}