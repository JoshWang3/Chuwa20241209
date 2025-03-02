package com.chuwa.learn;

// Main class to test the Parking Lot system
public class ParkingLotSystem {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(3);

        // Create vehicles
        Vehicle car1 = new Vehicle("ABC123");
        Vehicle car2 = new Vehicle("XYZ789");
        Vehicle car3 = new Vehicle("LMN456");
        Vehicle car4 = new Vehicle("PQR111");

        // Park vehicles
        lot.parkVehicle(car1);
        lot.parkVehicle(car2);
        lot.parkVehicle(car3);

        System.out.println("Available spaces: " + lot.getAvailableSpaces());

        // Attempt to park another vehicle
        lot.parkVehicle(car4);

        // Remove a vehicle
        lot.removeVehicle("XYZ789");
        System.out.println("Available spaces: " + lot.getAvailableSpaces());

        // Park the fourth vehicle again
        lot.parkVehicle(car4);
        System.out.println("Available spaces: " + lot.getAvailableSpaces());
    }
}
