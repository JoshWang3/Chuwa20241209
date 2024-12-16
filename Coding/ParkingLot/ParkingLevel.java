class ParkingLevel {
    private String levelId;
    private Map<ParkingSpotType, List<ParkingSpot>> spots;

    public ParkingFloor(String levelId) {
        this.levelId = levelId;
        this.spots = new HashMap<>();
        spots.put(ParkingSpotType.SMALL, new ArrayList<>());
        spots.put(ParkingSpotType.MEDIUM, new ArrayList<>());
        spots.put(ParkingSpotType.LARGE, new ArrayList<>());
    }

    public void addParkingSpot(ParkingSpot spot) {
        spots.get(spot.getType()).add(spot);
    }

    public ParkingSpot findAvailableSpot(VehicleType type) {
        ParkingSpotType requiredType = mapVehicleToSpot(type);
        for (ParkingSpot spot : spots.get(requiredType)) {
            if (spot.isAvailable()) {
                return spot;
            }
        }
        return null;
    }

    private ParkingSpotType mapVehicleToSpot(VehicleType type) {
        switch (type) {
            case BIKE:
                return ParkingSpotType.SMALL;
            case CAR:
                return ParkingSpotType.MEDIUM;
            case TRUCK:
                return ParkingSpotType.LARGE;
            default:
                throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}
