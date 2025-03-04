package Builder;

public class Director {
    private Builder mBuilder;

    public Director(Builder builder) {
        this.mBuilder = builder;
    }

    public Bike construct() {
        mBuilder.buildFrame();
        mBuilder.buildSeat();
        return mBuilder.createBike();
    }
}

