package builder.demo1;

public abstract class Builder {
    protected Bike bike = new Bike();
    public abstract void buildFrame();
    public abstract void buildSeat();

    //
    public abstract Bike createBike();

    /* Violating Single responsibility
    public Bike construct() {
        this.buildFrame();
        this.buildSeat();
        return this.createBike();
    }
    */
}
