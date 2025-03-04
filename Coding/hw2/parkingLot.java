// Design a parking lot using object-oriented priciples.

/*
1. Tha parking lot has multiple levels, each levels has multiple rows of spots
2. The parking lot can park motocycles, cars, buses
3. The parking lot has motocycle spots, compact spots, large spots
4. Motocycles can park in any spots
5. Cars can park in compact spots and large spots
6. Buses can park in five large spots that are consecutive and within the same row.
 */


// https://github.com/apriljdai/CC150/blob/master/Object-Oriented%20Design/ParkingLot.java
// ParkingSpot to handle the different parking spot size

public enum VehicleSize {
    Motocycle,
    Compact,
    Large,
}

public abstract class Vehicle {
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleSize size;

    public int getSptsNeeded() {
        return  spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void parkInSpot(parkingSpot s) {
        parkingSpots.add(s);
    }

    public void clearSpots() {
        for (int i = 0; i < parkingSpots.size(); i++) {
            parkingSpots.get(i).removeVehicle();
        }
        parkingSpots.clear();
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);
}

public class Bus extends Vehicle {
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large;
    }
}

public class Car extends Vehicle {
    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
    }
}

public class Motocycle extends Vehicle {
    public Motocycle() {
        spotsNeeded = 1;
        size = VehicleSize.Motocycle;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact || spot.getSize() == VehicleSize.Motocycle;
    }
}

public class ParkingLot {
    private Level[] levels;
    private final int NUM_LEVELS = 5;

    public ParkingLot() {
        levels = new Level[NUM_LEVELS];
        for (int i = 0; i < NUM_LEVELS; i ++) {
            levels[i] = new Level(i, 30);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (int i = 0; i < levels.length; i++) {
            if (levels[i].parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }
}

public class Level {

}

public class ParkingSpot {

}