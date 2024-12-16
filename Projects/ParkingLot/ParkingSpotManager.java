class ParkingSpot {
    private Vehicle vehicle;
    private String type;
    private boolean occupied;

    public ParkingSpot() {
        this.occupied = false;
    }

    // Getters and setters
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean getOccupied() {
        return occupied;
    }
}

class MotorcycleSpot extends ParkingSpot {
    public MotorcycleSpot() {
        super();
    }
}

class CompactSpot extends ParkingSpot {
    public CompactSpot() {
        super();
    }
}

class LargeSpot extends ParkingSpot {
    public LargeSpot() {
        super();
    }
}

// ParkingSpotFactory to create instances of ParkingSpot subclasses
class ParkingSpotFactory {
    public ParkingSpot createParkingSpot(String type) {
        switch (type) {
            case "Compact":
                return new CompactSpot();
            case "Large":
                return new LargeSpot();
            case "Motorcycle":
                return new MotorcycleSpot();
            default:
                throw new IllegalArgumentException("Invalid parking spot type: " + type);
        }
    }
}

// ParkingSpotManager class to manage parking spot operations
class ParkingSpotManager {
    public boolean isOccupied(ParkingSpot spot) {
        return spot.getVehicle() != null;
    }

    // Member function to park a vehicle in a parking spot
    public void parkVehicle(ParkingSpot spot, Vehicle vehicle, String type) {
        spot.setVehicle(vehicle);
        spot.setType(type);
    }

    // Member function to remove a vehicle from a parking spot
    public void removeVehicle(ParkingSpot spot) {
        spot.setVehicle(null);
        spot.setType(""); // Reset type
    }

    // Member function to get a parking spot for a specific vehicle
    public ParkingSpot getSpotForVehicle(ParkingLot parkingLot, Vehicle vehicle) {
        for (ParkingFloor floor : parkingLot.getFloors()) {
            for (ParkingSpot spot : floor.getSpots()) {
                if (isOccupied(spot) && spot.getVehicle().equals(vehicle)) {
                    return spot;
                }
            }
        }
        return null; // Return null if no spot found for the vehicle
    }

    // Member function to free up a parking spot
    public void freeParkingSpot(ParkingSpot spot) {
        spot.setVehicle(null);
        spot.setOccupied(false);
    }
}