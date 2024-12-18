package Builder;

public class Bike {
    private String frame;
    private String seat;

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getFrame() {
        return frame;
    }

    public String getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return "Bike [Frame: " + frame + ", Seat: " + seat + "]";
    }
}

