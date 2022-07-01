package scooteq.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import scooteq.model.Ride;
import scooteq.views.MainView;

public class MainController {

    private MainView mainView;
    private Ride ride;

    public MainController(MainView mainView) {
        this.mainView = mainView;
        this.ride = new Ride();
    }

    public ActionListener StartRideListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ride.start();
                    mainView.setStartTimeStampLabel(ride.getTimeOfRideStartInMilliseconds().toString());
                    mainView.setPriceOutput("Beende die Fahrt, um den Preis zu kalkulieren...");
                    mainView.switchButtonsEnabled(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    
                }
                ;
            }
        };
    }

    public ActionListener EndRideListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ride.end();
                    ride.calculateDurationInSeconds();
                    ride.calculatePrice();
                    mainView.setPriceOutput("Fahrpreis: " + ride.getRidePrice() + " Eur");
                    mainView.setEndTimeStampLabel(ride.getTimeOfRideEndInMilliseconds().toString());
                    mainView.setDuration("Fahrdauer: " + ride.getDurationInMinutes() + " Minute(n)");
                    mainView.switchButtonsEnabled(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
    }

}
