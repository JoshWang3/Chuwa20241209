package com.hw2.ParkingLot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ParkingSpot {
    private int spotNumber;
    private VehicleType type;
    private boolean isAvailable;

    // Constructor with two parameters (defaults isAvailable to true)
    public ParkingSpot(int spotNumber, VehicleType type) {
        this(spotNumber, type, true); // Call the three-parameter constructor
    }
    public void occupy() {
        isAvailable = false;
    }

    public void release() {
        isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public VehicleType getType() {
        return type;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}