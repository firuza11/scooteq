package scooteq.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import scooteq.model.Ride;
import scooteq.views.MainPanel;
import scooteq.views.MainView;

public class MainController {

    
    private MainPanel mainPanel;
    private Ride ride;

    /**
     * Creates a new {@code MainController} that is called from the mainview
     * @param mainView
     */
    public MainController(MainView mainView) {
        this.mainPanel = mainView.getMainPanel();
        this.ride = new Ride();
    }


    /**
     * 
     * @return
     */
    public ActionListener StartRideListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ride.start();
                mainPanel.setStartTimeStampLabel(ride.getTimeOfRideStartInMilliseconds().toString());
                mainPanel.setPriceOutput("Beende die Fahrt, um den Preis zu kalkulieren...");
                mainPanel.switchButtonsEnabled(true);
            }
        };
    }

    /**
     * 
     * @return
     */
    public ActionListener EndRideListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ride.end();
                    ride.calculateDurationInSeconds();
                    ride.calculatePrice();
                    mainPanel.setPriceOutput("Fahrpreis: " + ride.getRidePrice() + " Eur");
                    mainPanel.setEndTimeStampLabel(ride.getTimeOfRideEndInMilliseconds().toString());
                    mainPanel.setDurationLabel("Fahrdauer: " + ride.getDurationInMinutes() + " Minute(n)");
                    mainPanel.switchButtonsEnabled(false);
                } catch (Exception ex) {
                    mainPanel.setPriceOutput("Fehler bei der Preiskalkulation");
                    ex.printStackTrace();
                }
            }
        };
    }

}
