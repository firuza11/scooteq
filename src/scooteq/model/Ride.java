package scooteq.model;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.Instant;

public class Ride {
    private final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");
    private final double PRICE_PER_MINUTE = 0.15;
    private final double PRICE_BASE = 2;
    private String ridePrice = "";
    private Timestamp timeOfRideStartInMilliseconds;
    private Timestamp timeOfRideEndInMilliseconds;
    private long durationInSeconds;

    /**
     * Saves the current time at the start of the {@code Ride}.
     */
    public void start() {
        Instant rightNow = Instant.now();
        timeOfRideStartInMilliseconds = Timestamp.from(rightNow);
    }

    /**
     * Saves the current time at the end of the {@code Ride}.
     */
    public void end() {
        Instant rightNow = Instant.now();
        timeOfRideEndInMilliseconds = Timestamp.from(rightNow);
    }

    /**
     * Calculates the difference between the start and end time of this {@code Ride}
     * object without
     * milliseconds.
     * 
     * @throws NullPointerException If the start time or end time have not been set.
     */
    public void calculateDurationInSeconds() throws NullPointerException {
        durationInSeconds = (timeOfRideEndInMilliseconds.getTime() - timeOfRideStartInMilliseconds.getTime()) / 1000;
    }

    /**
     * Calculates the price of the ride from this {@code Ride} object's duration.
     * From the price per completed minute of the ride added to the base price.
     */
    public void calculatePrice() {
        long durationInMinutes = durationInSeconds / 60;
        ridePrice = DECIMAL_FORMAT.format(durationInMinutes * PRICE_PER_MINUTE + PRICE_BASE);
    }

    /**
     * Returns the price of this {@code Ride} object. Will
     * return an empty {@code String} if no ride has been completed.
     * 
     * @return the price of this {@code Ride}
     */
    public String getRidePrice() {
        return ridePrice;
    }

    /**
     * The start time of the ride with milliseconds.
     * 
     * @return The start of the ride with milliseconds
     */
    public Timestamp getTimeOfRideStartInMilliseconds() {
        timeOfRideStartInMilliseconds.setNanos(0);
        return timeOfRideStartInMilliseconds;
    }

    /**
     * The end time of the ride with milliseconds.
     * 
     * @return The end of the ride with milliseconds
     */
    public Timestamp getTimeOfRideEndInMilliseconds() {
        timeOfRideEndInMilliseconds.setNanos(0);
        return timeOfRideEndInMilliseconds;
    }

    /**
     * The duration of this {@code Ride} object in minutes.
     * @return the duretion of the ride
     */
    public long getDurationInMinutes() {
        return durationInSeconds / 60;
    }
}
