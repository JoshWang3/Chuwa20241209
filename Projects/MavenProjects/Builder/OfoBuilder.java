package Builder;

public class OfoBuilder extends Builder {
    @Override
    public void buildFrame() {
        mBike.setFrame("Aluminum Frame");
        System.out.println("Building Ofo Frame: Aluminum");
    }

    @Override
    public void buildSeat() {
        mBike.setSeat("Leather Seat");
        System.out.println("Building Ofo Seat: Leather");
    }
}

