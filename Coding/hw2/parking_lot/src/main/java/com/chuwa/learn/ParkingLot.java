package com.chuwa.learn;

import java.util.HashMap;

// ParkingLot class
class ParkingLot {
    private int capacity; // Total parking slots
    private HashMap<String, Vehicle> parkedVehicles;

    // Constructor
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        parkedVehicles = new HashMap<>();
    }

    // Add a vehicle to the parking lot
    public void parkVehicle(Vehicle vehicle) {
        if (parkedVehicles.size() >= capacity) {
            System.out.println("Parking Lot is Full!");
            return;
        }
        parkedVehicles.put(vehicle.getLicensePlate(), vehicle);
        System.out.println("Vehicle with license plate " + vehicle.getLicensePlate() + " parked.");
    }

    // Remove a vehicle from the parking lot
    public void removeVehicle(String licensePlate) {
        if (parkedVehicles.containsKey(licensePlate)) {
            parkedVehicles.remove(licensePlate);
            System.out.println("Vehicle with license plate " + licensePlate + " removed.");
        } else {
            System.out.println("Vehicle not found!");
        }
    }

    // Check available spaces
    public int getAvailableSpaces() {
        return capacity - parkedVehicles.size();
    }
}
