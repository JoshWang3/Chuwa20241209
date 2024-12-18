public class Car {
    private String licensePlate;
    private CarType carType;
    private long entryTime;

    public Car(String licensePlate, CarType carType) {
        this.licensePlate = licensePlate;
        this.carType = carType;
        this.entryTime = System.currentTimeMillis();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public CarType getCarType() {
        return carType;
    }

    public long getEntryTime() {
        return entryTime;
    }
}
