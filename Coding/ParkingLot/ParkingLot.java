class ParkingLot {
    private String name;
    private List<ParkingLevel> levels;

    public ParkingLot(String name) {
        this.name = name;
        this.levels = new ArrayList<>();
    }

    public void addLevel(ParkingLevel level) {
        levels.add(level);
    }

    public ParkingSpot parkVehivle(Vehicle vehicle) {
        for (ParkingLevel level : levels) {
            ParkingLot spot = level.findAvailableSpot(vehicle.getType());
            if (spot != null) {
                spot.parkVehivle();
                return spot;
            }
        }
        throw new IllegalStateException("No avaiable parking spots");
    }

    public void removeVehicle(ParkingSpot spot) {
        spot.removeVehible();
    }
}