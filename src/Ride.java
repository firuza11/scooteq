import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.Instant;

public class Ride {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private Timestamp timeOfRideStartInMilliseconds;
    private Timestamp timeOfRideEndInMilliseconds;
    private long durationInSeconds;
    private String ridePrice;

    public void start() {
        Instant rightNow = Instant.now();
        timeOfRideStartInMilliseconds = Timestamp.from(rightNow);
    }

    public void end() {
        Instant rightNow = Instant.now();
        timeOfRideEndInMilliseconds = Timestamp.from(rightNow);
    }

    public void calculateDurationInSeconds() {
        durationInSeconds = (timeOfRideEndInMilliseconds.getTime() -timeOfRideStartInMilliseconds.getTime()) / 1000;
        System.out.println("Duration" + durationInSeconds);
    }

    public void calculatePrice() {
        long  durationInMinutes = durationInSeconds / 60;
        System.out.println("Duration Minutes" + durationInMinutes);
        ridePrice = df.format(durationInMinutes * 0.15);
    }

    public String getRidePrice() {
        System.out.println("Ride Price"+ ridePrice);
        return ridePrice;
    }
}
