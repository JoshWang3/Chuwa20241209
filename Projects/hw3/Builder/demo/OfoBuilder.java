public class OfoBuilder extends Builder {
    public void buildFrame() {
        bike.setFrame("A");
    }

    public void buildSeat() {
        bike.setSeat("Z");
    }

    public Bike createBike() {
        return bike;
    }
}