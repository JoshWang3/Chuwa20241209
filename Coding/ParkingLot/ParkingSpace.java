public class ParkingSpace {
    private int id;
    private boolean isOccupied;
    private Car parkedCar;

    public ParkingSpace(int id) {
        this.id = id;
        this.isOccupied = false;
        this.parkedCar = null;
    }

    public boolean parkCar(Car car) {
        if (isOccupied) {
            System.out.println("Parking space " + id + " is already occupied.");
            return false;
        }
        this.parkedCar = car;
        this.isOccupied = true;
        return true;
    }

    public Car removeCar() {
        if (!isOccupied) {
            System.out.println("Parking space " + id + " is empty.");
            return null;
        }
        Car car = parkedCar;
        this.parkedCar = null;
        this.isOccupied = false;
        return car;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public int getId() {
        return id;
    }

    public Car getParkedCar() {
        return parkedCar;
    }
}
