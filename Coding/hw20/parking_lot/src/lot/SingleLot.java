package lot;

import vehicle.Vehicle;

public class SingleLot {
    private int id;
    private boolean empty;
    private Vehicle vehicle;

    public SingleLot(int id) {
        this.id = id;
        this.empty = true;
        this.vehicle = null;
    }

    public int getId() {
        return id;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
        if (empty) {
            this.vehicle = null;
        }
    }

    public boolean setVehicle(Vehicle vehicle) {
        if (this.isEmpty()) {
            this.vehicle = vehicle;
            this.empty = false;
            return true;
        }
        return false;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
