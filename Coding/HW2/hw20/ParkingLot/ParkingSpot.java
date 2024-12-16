package Chuwa20241209.Coding.HW2.hw20.ParkingLot;

enum SpotType {
    SMALL, MEDIUM, LARGE, ELECTRIC
}

enum Level {
    LEVEL_1, LEVEL_2, LEVEL_3; // Add levels as needed
}

public class ParkingSpot {
    private SpotType type;       // Type of parking spot: SMALL, MEDIUM, LARGE
    private boolean isAvailable; // Availability status
    private Vehicle parkedVehicle; // The vehicle currently parked in this spot
    private Level level;         // The level (floor) of the parking spot

    public ParkingSpot(SpotType type, Level level) {
        this.type = type;
        this.level = level;
        this.isAvailable = true; // All spots start as available
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public SpotType getType() {
        return type;
    }

    public Level getLevel() {
        return level;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isAvailable = false;
    }

    public void unparkVehicle() {
        this.parkedVehicle = null;
        this.isAvailable = true;
    }
}

