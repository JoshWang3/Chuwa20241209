package Chuwa20241209.Coding.HW2.hw20.ParkingLot;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private String parkingLotId;         // ID of the parking lot
    private List<ParkingSpot> spots;    // List of all parking spots in the lot

    // Constructor
    public ParkingLot(String parkingLotId) {
        this.parkingLotId = parkingLotId;
        this.spots = new ArrayList<>();
    }

    // Method to add parking spots to the lot
    public void addParkingSpots(SpotType type, Level level, int count) {
        for (int i = 0; i < count; i++) {
            spots.add(new ParkingSpot(type, level));
        }
    }

    // Get all available spots for a specific vehicle type and level
    public List<ParkingSpot> getAvailableSpots(VehicleType vehicleType, Level level) {
        List<ParkingSpot> availableSpots = new ArrayList<>();
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.getLevel() == level && canFitVehicle(spot, vehicleType)) {
                availableSpots.add(spot);
            }
        }
        return availableSpots;
    }

    // Get all unavailable spots for a specific vehicle type and level
    public List<ParkingSpot> getUnavailableSpots(VehicleType vehicleType, Level level) {
        List<ParkingSpot> unavailableSpots = new ArrayList<>();
        for (ParkingSpot spot : spots) {
            if (!spot.isAvailable() && spot.getLevel() == level && canFitVehicle(spot, vehicleType)) {
                unavailableSpots.add(spot);
            }
        }
        return unavailableSpots;
    }

    // Display all available spots for a specific vehicle type and level
    public void displayAvailableSpots(VehicleType vehicleType, Level level) {
        List<ParkingSpot> availableSpots = getAvailableSpots(vehicleType, level);
        System.out.println("Available spots for " + vehicleType + " on " + level + ": " + availableSpots.size());
    }

    // Display all unavailable spots for a specific vehicle type and level
    public void displayUnavailableSpots(VehicleType vehicleType, Level level) {
        List<ParkingSpot> unavailableSpots = getUnavailableSpots(vehicleType, level);
        System.out.println("Unavailable spots for " + vehicleType + " on " + level + ": " + unavailableSpots.size());
    }

    // Check if a parking spot can fit a given vehicle
    private boolean canFitVehicle(ParkingSpot spot, VehicleType vehicleType) {
        if (vehicleType == VehicleType.MOTORCYCLE && spot.getType() == SpotType.SMALL) return true;
        if (vehicleType == VehicleType.CAR && spot.getType() == SpotType.MEDIUM) return true;
        if (vehicleType == VehicleType.BUS && spot.getType() == SpotType.LARGE) return true;
        return false;
    }

    // Park a vehicle in the first available spot
    public boolean parkVehicle(Vehicle vehicle, Level level) {
        List<ParkingSpot> availableSpots = getAvailableSpots(vehicle.getType(), level);
        if (!availableSpots.isEmpty()) {
            availableSpots.get(0).parkVehicle(vehicle); // Park in the first available spot
            System.out.println(vehicle.getType() + ": " + vehicle.getLicensePlate() + " parked on " + level);
            return true;
        }
        System.out.println("Sorry, " + vehicle.getLicensePlate() + ", no available spot, please try other levels");
        return false;
    }

    // Unpark a vehicle
    public boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isAvailable() && spot.getParkedVehicle() == vehicle) {
                spot.unparkVehicle();
                System.out.println(vehicle.getType() + ": " + vehicle.getLicensePlate() + " unparked.");
                return true;
            }
        }
        return false;
    }
}

