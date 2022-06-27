import java.sql.Timestamp;
import java.time.Instant;

public class Ride {
    private Timestamp timeOfRideStartInMilliseconds;
    private Timestamp timeOfRideEndInMilliseconds;
    private long durationInSeconds;
    private long ridePrice;

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
        System.out.println(durationInSeconds);
    }

    public void calculatePrice() {
        long  durationInMinutes = durationInSeconds / 60;
        ridePrice = (long) (durationInMinutes * 0.15);
    }

    public long getRidePrice() {
        System.out.println(ridePrice);
        return ridePrice;
    }
}
