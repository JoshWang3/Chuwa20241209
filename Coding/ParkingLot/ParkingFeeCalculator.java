
public class ParkingFeeCalculator {
    private static final long SMALL_CAR_RATE = 10;
    private static final long MEDIUM_CAR_RATE = 15;
    private static final long LARGE_CAR_RATE = 20;

    public long calculateFee(Car car) {
        long parkedDuration = (System.currentTimeMillis() - car.getEntryTime()) / (1000 * 60 * 60); // Hours

        switch (car.getCarType()) {
            case SMALL:
                return parkedDuration * SMALL_CAR_RATE;
            case MEDIUM:
                return parkedDuration * MEDIUM_CAR_RATE;
            case LARGE:
                return parkedDuration * LARGE_CAR_RATE;
            default:
                return 0;
        }
    }
}

