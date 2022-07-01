package scooteq.model;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.Instant;

public class Ride {
    private static final DecimalFormat decimalformat = new DecimalFormat("0.00");
    private final double PRICE_PER_MINUTE = 0.15;
    private final double PRICE_BASE = 2;
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
        durationInSeconds = (timeOfRideEndInMilliseconds.getTime() - timeOfRideStartInMilliseconds.getTime()) / 1000;
    }

    public void calculatePrice() {
        long durationInMinutes = durationInSeconds / 60;
        ridePrice = decimalformat.format(durationInMinutes * PRICE_PER_MINUTE + PRICE_BASE);
    }

    public String getRidePrice() {
        return ridePrice;
    }

    public Timestamp getTimeOfRideStartInMilliseconds() {
        timeOfRideStartInMilliseconds.setNanos(0);
        return timeOfRideStartInMilliseconds;
    }

    public Timestamp getTimeOfRideEndInMilliseconds() {
        timeOfRideEndInMilliseconds.setNanos(0);
        return timeOfRideEndInMilliseconds;
    }

    public long getDurationInMinutes() {
        return durationInSeconds / 60;
    }
}
