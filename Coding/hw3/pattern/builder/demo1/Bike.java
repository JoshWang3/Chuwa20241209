package builder.demo1;

public class Bike {
    public String getFrame() {
        return frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    private String frame;
    private String seat;
}
