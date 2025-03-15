package com.hw2.ParkingLot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Vehicle {
    private String licensePlate;
    private VehicleType type;

    // Parameterized constructor (for subclasses)
    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }
    public VehicleType getType() {
        return type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}

