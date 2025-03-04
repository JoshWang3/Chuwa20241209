package coding1;

import java.util.HashMap;
import java.util.Map;

// Represents a Parking Lot system
class ParkingLot {
    private int capacity;  // Total parking spots
    private Map<Integer, String> parkedCars;  // Spot number and car's license plate

    // Constructor to initialize the parking lot
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkedCars = new HashMap<>();
        System.out.println("Parking Lot initialized with capacity: " + capacity);
    }

    // Park a car in the parking lot
    public boolean parkCar(int spot, String licensePlate) {
        if (spot < 1 || spot > capacity) {
            System.out.println("Invalid spot number: " + spot);
            return false;
        }
        if (parkedCars.containsKey(spot)) {
            System.out.println("Spot " + spot + " is already occupied.");
            return false;
        }
        parkedCars.put(spot, licensePlate);
        System.out.println("Car with license " + licensePlate + " parked at spot " + spot);
        return true;
    }

    // Remove a car from the parking lot
    public boolean removeCar(int spot) {
        if (parkedCars.containsKey(spot)) {
            String removedCar = parkedCars.remove(spot);
            System.out.println("Car with license " + removedCar + " removed from spot " + spot);
            return true;
        }
        System.out.println("No car found at spot " + spot);
        return false;
    }

    // Display the current status of the parking lot
    public void displayStatus() {
        System.out.println("Parking Lot Status:");
        for (int i = 1; i <= capacity; i++) {
            if (parkedCars.containsKey(i)) {
                System.out.println("Spot " + i + ": " + parkedCars.get(i));
            } else {
                System.out.println("Spot " + i + ": Empty");
            }
        }
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5); // Initialize a parking lot with 5 spots

        parkingLot.parkCar(1, "ABC123");
        parkingLot.parkCar(3, "XYZ789");
        parkingLot.parkCar(3, "LMN456");  // Attempt to park at an occupied spot
        parkingLot.removeCar(2);          // Attempt to remove from an empty spot
        parkingLot.removeCar(1);
        parkingLot.displayStatus();
    }
}
