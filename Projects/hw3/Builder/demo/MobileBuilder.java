public class MobileBuilder extends Builder {
    public buildFrame() {
        bike.setframe("A");
    }

    public void buildSeat() {
        bike.setSeat("Z");
    }

    public Bike createBike() {
        return bike;
    }
}