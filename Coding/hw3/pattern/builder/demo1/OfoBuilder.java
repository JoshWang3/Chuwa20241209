package builder.demo1;

public class OfoBuilder extends Builder {
    public void buildFrame() {
        bike.setFrame("Aluminium frame");
    }

    public void buildSeat() {
        bike.setSeat("Rubber Seat");
    }

    public Bike createBike() {
        return bike;
    }
}
