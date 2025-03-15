package com.hw2.ParkingLot.model;

import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ParkingLot {
    private List<Level> levels;

    public ParkingLot(int numberOfLevels, int spotsPerLevel) {
        levels = new ArrayList<>();
        for (int i = 1; i <= numberOfLevels; i++) {
            levels.add(new Level(i, spotsPerLevel));
        }
    }

    public void parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            level.parkVehicle(vehicle);
            return; // Park in the first available level
        }
        System.out.println("Parking lot is full.");
    }

    public void releaseVehicle(int levelNumber, int spotNumber) {
        if (levelNumber <= levels.size()) {
            Level level = levels.get(levelNumber - 1);
            ParkingSpot spot = level.findAvailableSpot(VehicleType.CAR); // Simplified for demo
            if (spot != null) {
                level.releaseVehicle(spot);
            } else {
                System.out.println("Invalid spot number.");
            }
        } else {
            System.out.println("Invalid level number.");
        }
    }
}