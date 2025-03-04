package Builder;

public abstract class Builder {
    protected Bike mBike = new Bike();

    public abstract void buildFrame();
    public abstract void buildSeat();

    public Bike createBike() {
        return mBike;
    }
}

