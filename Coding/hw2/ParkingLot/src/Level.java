import java.util.ArrayList;
import java.util.List;

public class Level {
    private int floorNumber;
    private List<ParkingSpot> spots;

    public Level(int floorNumber, int numSmall, int numMedium, int numLarge) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();
        for (int i = 0; i < numSmall; i++) {
            spots.add(new ParkingSpot(SpotType.SMALL));
        }
        for (int i = 0; i < numMedium; i++) {
            spots.add(new ParkingSpot(SpotType.MEDIUM));
        }
        for (int i = 0; i < numLarge; i++) {
            spots.add(new ParkingSpot(SpotType.LARGE));
        }
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && spot.canFitVehicle(vehicle)) {
                return spot;
            }
        }
        return null;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle);
        if (spot != null) {
            return spot.park(vehicle);
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getType().ordinal() >= vehicle.getType().ordinal()) {
                Vehicle current = spot.getCurrentVehicle();
                if (current != null && current.getLicensePlate().equals(vehicle.getLicensePlate())) {
                    spot.unpark();
                    return true;
                }
            }
        }
        return false;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
