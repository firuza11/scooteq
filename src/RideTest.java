public class RideTest {

    public static void main(String[] args) {
        Ride newRide = new Ride();
        newRide.start();
        newRide.end();
        newRide.calculateDurationInSeconds();
        newRide.calculatePrice();
        newRide.getRidePrice();
    }
}
