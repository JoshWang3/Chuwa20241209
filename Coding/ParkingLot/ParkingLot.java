import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Integer, ParkingSpace> spaces;

    public ParkingLot(int numSpaces) {
        spaces = new HashMap<>();
        for (int i = 1; i <= numSpaces; i++) {
            spaces.put(i, new ParkingSpace(i));
        }
    }

    public boolean parkCar(Car car) {
        for (ParkingSpace space : spaces.values()) {
            if (!space.isOccupied()) {
                return space.parkCar(car);
            }
        }
        System.out.println("Parking lot is full, unable to park.");
        return false;
    }

    public void removeCar(String licensePlate) {
        for (ParkingSpace space : spaces.values()) {
            if (space.isOccupied() && space.getParkedCar().getLicensePlate().equals(licensePlate)) {
                Car car = space.removeCar();
                System.out.println("Car with license plate " + car.getLicensePlate() + " has been removed.");
                return;
            }
        }
        System.out.println("Car with license plate " + licensePlate + " not found.");
    }

    public void showParkingLotStatus() {
        for (ParkingSpace space : spaces.values()) {
            System.out.println("Parking space " + space.getId() + " : " + (space.isOccupied() ? "Occupied" : "Available"));
        }
    }
}
