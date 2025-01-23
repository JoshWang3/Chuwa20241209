package lot;

import vehicle.Vehicle;

public class ParkLots {
    private int numLots;
    private SingleLot[] lots;

    public ParkLots(int numLots) {
        this.numLots = numLots;
        lots = new SingleLot[numLots];
        for (int i = 0; i < numLots; i++) {
            lots[i] = new SingleLot(i);
        }
    }

    public int getNumLots() {
        return numLots;
    }

    public SingleLot getLot(int lotId) {
        return lots[lotId];
    }

    public SingleLot getAvailableSpot() {
        for (SingleLot lot : lots) {
            if (lot.isEmpty()) {
                return lot;
            }
        }
        return null;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        SingleLot lot = getAvailableSpot();
        if (lot.setVehicle(vehicle)) {
            System.out.println(vehicle.getLicensePlate() + " parked at spot " + lot.getId());
            return true;
        }

        System.out.println("Sorry, no available spots");
        return false;
    }

    public boolean leaveVehicle(Vehicle vehicle) {
        for (SingleLot lot : lots) {
            if (lot.getVehicle().getLicensePlate().equals(vehicle.getLicensePlate())) {
                lot.setEmpty(true);
                System.out.println(vehicle.getLicensePlate() + " left spot " + lot.getId());
                return true;
            }
        }
        System.out.println(vehicle.getLicensePlate() + " not found.");
        return false;
    }

}
