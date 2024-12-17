public class ParkingLot {
    private Spot[] spots;

    public ParkingLot(int num) {
        spots = new Spot[num];
        for (int i = 0; i < num; i++) {
            spots[i] = new Spot(i + 1);
        }
    }

    public Spot getAvailableSpot() {
        for (Spot spot : spots) {
            if (spot.isAvailable()) {
                return spot;
            }
        }
        return null;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        Spot spot = getAvailableSpot();
        if (spot != null) {
            spot.park(vehicle);
            System.out.println(vehicle.getLicensePlate() + " parked at spot " + spot.getSpotId());
            return true;
        }
        System.out.println("Sorry, no available spots");
        return false;
    }

    public boolean leaveVehicle(Vehicle vehicle) {
        for (Spot spot : spots) {
            if (spot.getVehicle().equals(vehicle)) {
                spot.leave();
                System.out.println(vehicle.getLicensePlate() + " left spot " + spot.getSpotId());
                return true;
            }
        }
        System.out.println(vehicle.getLicensePlate() + " not found.");
        return false;
    }
}
