import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Level> levels;
    private int totalCapacity;

    public ParkingLot(int numLevels, int numSmallPerLevel, int numMediumPerLevel, int numLargePerLevel) {
        levels = new ArrayList<>();
        for (int i = 0; i < numLevels; i++) {
            levels.add(new Level(i + 1, numSmallPerLevel, numMediumPerLevel, numLargePerLevel));
        }
        totalCapacity = numLevels * (numSmallPerLevel + numMediumPerLevel + numLargePerLevel);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                System.out.println("Vehicle parked at level " + level.getFloorNumber());
                return true;
            }
        }
        System.out.println("Parking Lot Full");
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.unparkVehicle(vehicle)) {
                System.out.println("Vehicle unparked from level " + level.getFloorNumber());
                return true;
            }
        }
        System.out.println("Vehicle not found");
        return false;
    }
}
