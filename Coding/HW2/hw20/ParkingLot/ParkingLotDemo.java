package Chuwa20241209.Coding.HW2.hw20.ParkingLot;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot("Lot-1");
        // Add spots
        lot.addParkingSpots(SpotType.SMALL, Level.LEVEL_1, 5);
        lot.addParkingSpots(SpotType.MEDIUM, Level.LEVEL_1, 10);
        lot.addParkingSpots(SpotType.LARGE, Level.LEVEL_2, 2);


        Vehicle motorcycle = new Motorcycle("motorcycle_519");
        Vehicle car = new Car("car_4132");
        Vehicle bus = new Bus("bus_77");


        // Park vehicles
        lot.parkVehicle(motorcycle, Level.LEVEL_1);
        lot.parkVehicle(car, Level.LEVEL_1);
        lot.parkVehicle(bus, Level.LEVEL_1);

        // Check available spots for cars
        lot.displayAvailableSpots(VehicleType.CAR, Level.LEVEL_1);
        lot.displayUnavailableSpots(VehicleType.CAR, Level.LEVEL_1);

        lot.unparkVehicle(car);

    }
}
