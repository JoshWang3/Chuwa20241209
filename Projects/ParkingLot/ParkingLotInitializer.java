// ParkingLotInitializer class for initializing parking lot
class ParkingLotInitializer {
    private ParkingLot parkingLot;
    private ParkingSpotFactory spotFactory;

    // Constructors
    public ParkingLotInitializer(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.spotFactory = new ParkingSpotFactory();
    }

    // Getters and setters
    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    // Member function
    public void initializeParkingLot(int numberOfFloors, int spotsPerFloor) {
        List<ParkingFloor> floors = new ArrayList<>();
        List<String> spotTypes = List.of("Compact", "Large", "Motorcycle");

        for (int i = 0; i < numberOfFloors; i++) {
            ParkingFloor floor = new ParkingFloor();
            for (int j = 0; j < spotsPerFloor; j++) {
                String spotType = spotTypes.get(j % spotTypes.size()); // Alternate spot types
                ParkingSpot spot = spotFactory.createParkingSpot(spotType);
                floor.addParkingSpot(spot);
            }
            floors.add(floor);
        }
        parkingLot.setFloors(floors);
    }
}
