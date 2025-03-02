package coding1;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final List<ParkingSpot> spots;

    public ParkingLot(int numCarSpots, int numTruckSpots) {
        spots = new ArrayList<>();
        for (int i = 0; i < numCarSpots; i++) {
            spots.add(new ParkingSpot("Car"));
        }
        for (int i = 0; i < numTruckSpots; i++) {
            spots.add(new ParkingSpot("Truck"));
        }
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.canFitVehicle(vehicle)) {
                spot.park(vehicle);
                return spot;
            }
        }
        throw new IllegalStateException("No available spot for the vehicle");
    }

    public void leaveSpot(ParkingSpot spot) {
        spot.leave();
    }

    public void displayStatus() {
        for (int i = 0; i < spots.size(); i++) {
            ParkingSpot spot = spots.get(i);
            System.out.println("Spot " + i + " (" + spot.getSpotType() + "): " +
                    (spot.isAvailable() ? "Available" : "Occupied by " + spot.getCurrentVehicle().getLicensePlate()));
        }
    }
}
