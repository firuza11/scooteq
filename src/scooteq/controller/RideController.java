package scooteq.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import scooteq.model.Ride;
import scooteq.view.MainView;
import scooteq.view.panels.RidePanel;

/**
 * This class controls the UI elements of the {@code RidePanel} and contains the
 * listeners to control rides.
 * 
 * @see RidePanel
 */
public class RideController {

    private RidePanel ridePanel;
    private Ride ride;

    /**
     * Creates a new {@code MainController} from the {@code MainView} that is
     * attached to the {@code RidePanel}
     * 
     * @param mainView the view that the controller is created from.
     */
    public RideController(MainView mainView) {
        this.ridePanel = mainView.getRidePanel();
        this.ride = new Ride();
    }

    /**
     * Creates an {@code ActionListener} that starts a ride, adds the current time
     * to the {@code RidePanel} and adds a new
     * message. The button start ride button gets disabled and the end ride button
     * enabled.
     * 
     * @return the Listener to start a ride.
     * @see Ride
     */
    public ActionListener StartRideListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ride.start();
                ridePanel.setStartTimeStampLabel(ride.getTimeOfRideStartInMilliseconds().toString());
                ridePanel.setPriceOutput("Beende die Fahrt, um den Preis zu kalkulieren...");
                ridePanel.switchButtonsEnabled(true);
            }
        };
    }

    /**
     * Creates an {@code ActionListener} that end a ride, adds the current time
     * to the {@code RidePanel}. It also triggers the price calculation.
     * message. The button end ride button gets disabled and the start ride button
     * enabled.
     * 
     * @return the Listener to end a ride.
     * @see Ride
     */
    public ActionListener EndRideListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ride.end();
                    ride.calculateDurationInSeconds();
                    ride.calculatePrice();
                    ridePanel.setPriceOutput("Fahrpreis: " + ride.getRidePrice() + " Eur");
                    ridePanel.setEndTimeStampLabel(ride.getTimeOfRideEndInMilliseconds().toString());
                    ridePanel.setDurationLabel("Fahrdauer: " + ride.getDurationInMinutes() + " Minute(n)");
                    ridePanel.switchButtonsEnabled(false);
                } catch (Exception ex) {
                    ridePanel.setPriceOutput("Fehler bei der Preiskalkulation");
                    ex.printStackTrace();
                }
            }
        };
    }

}
