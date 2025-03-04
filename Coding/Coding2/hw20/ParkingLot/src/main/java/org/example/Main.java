package org.example;

public class Main {
    public static void main(String[] args) {
        int nFloors=4;
        int nSlotsPerFloor=6;
        ParkingLot parkingLot = new ParkingLot("PR1234", nFloors, nSlotsPerFloor);

        System.out.println("No of open slots for car: " + parkingLot.getNoOfOpenSlots("car"));

        String ticket1 = parkingLot.parkVehicle("car", "MH-03", "red");
        String ticket2 = parkingLot.parkVehicle("car", "MH-04", "purple");
        System.out.println("After parking:");
        parkingLot.displayOccupiedSlots("car");

        parkingLot.unPark(ticket2);
        parkingLot.displayOccupiedSlots("car");

        parkingLot.displayOpenSlots("truck");
        parkingLot.parkVehicle("truck", "MH-01", "black");

        System.out.println();
        parkingLot.parkVehicle("truck", "MH-01-4532", "black");
        parkingLot.parkVehicle("truck", "MH-01-912", "black");
        parkingLot.parkVehicle("truck", "MH-01-0911", "black");
        System.out.println("After parking three more trucks:");

        parkingLot.parkVehicle("truck", "MH-01-723", "black");



    }
}