package Builder;

public class Client {
    public static void main(String[] args) {
        // Build Mobike
        Builder mobikeBuilder = new MobikeBuilder();
        Director director = new Director(mobikeBuilder);
        Bike mobike = director.construct();
        System.out.println("Constructed Mobike: " + mobike);

        System.out.println("-------------------------");

        // Build Ofo
        Builder ofoBuilder = new OfoBuilder();
        director = new Director(ofoBuilder);
        Bike ofoBike = director.construct();
        System.out.println("Constructed Ofo Bike: " + ofoBike);
    }
}

