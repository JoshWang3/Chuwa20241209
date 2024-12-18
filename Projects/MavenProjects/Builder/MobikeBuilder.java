package Builder;

public class MobikeBuilder extends Builder {
    @Override
    public void buildFrame() {
        mBike.setFrame("Carbon Fiber Frame");
        System.out.println("Building Mobike Frame: Carbon Fiber");
    }

    @Override
    public void buildSeat() {
        mBike.setSeat("Rubber Seat");
        System.out.println("Building Mobike Seat: Rubber");
    }
}

