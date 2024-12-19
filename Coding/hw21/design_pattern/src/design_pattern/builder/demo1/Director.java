package design_pattern.builder.demo1;

public class Director {

    private Builder builder;

    public Director(Builder b) {
        builder = b;
    }

    public Bike constructBike() {
        builder.buildFrame();
        builder.buildSeat();
        return builder.produceBike();
    }
}
