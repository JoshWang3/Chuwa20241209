package com.hw2.ParkingLot.model;

import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Level {
    private int levelNumber;
    private List<ParkingSpot> spots;

    public Level(int levelNumber, int numberOfSpots) {
        this.levelNumber = levelNumber;
        this.spots = new ArrayList<>();
        for (int i = 1; i <= numberOfSpots; i++) {
            spots.add(new ParkingSpot(i, VehicleType.CAR)); // Use the two-parameter constructor
        }
    }

    public ParkingSpot findAvailableSpot(VehicleType type) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.getType() == type) {
                return spot;
            }
        }
        return null;
    }

    public void parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle.getType());
        if (spot != null) {
            spot.occupy();
            System.out.println(vehicle.getType() + " with license plate " + vehicle.getLicensePlate() + " parked at spot " + spot.getSpotNumber());
        } else {
            System.out.println("No available spot for " + vehicle.getType());
        }
    }

    public void releaseVehicle(ParkingSpot spot) {
        spot.release();
        System.out.println("Spot " + spot.getSpotNumber() + " is now available.");
    }
}