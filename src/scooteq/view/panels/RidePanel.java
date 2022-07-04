package scooteq.view.panels;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scooteq.controller.RideController;
import scooteq.view.MainView;

/**
 * This class contains the UI elements to start and end scooteq rides. It will
 * also display several messages that are dynamically added to the panel by the
 * {@code MainController}.
 * 
 * @see RideController
 */
public class RidePanel extends JPanel {

    private RideController controller;
    private JLabel priceOutput;
    private JLabel startTimeStampLabel;
    private JLabel endTimeStampLabel;
    private JLabel duration;
    private JButton endRideButton;
    private JButton startRideButton;
    private MainView mainView;

    /**
     * Creates a new RidePanel from the {@code MainView}.
     * 
     * @param mainView the view that the panel will be added to.
     */
    public RidePanel(MainView mainView) {
        this.mainView = mainView;
    }

    /**
     * Initializes the UI elements of the panel including listeners.
     */
    public void init() {
        this.controller = new RideController(mainView);
        JLabel goLabel = new JLabel("Los geht's :)");
        goLabel.setBounds(40, 100, 150, 30);

        startRideButton = new JButton("Fahrt starten");
        startRideButton.setBounds(40, 150, 200, 30);
        startRideButton.addActionListener(controller.StartRideListener());

        startTimeStampLabel = new JLabel("");
        startTimeStampLabel.setBounds(250, 150, 200, 30);

        endRideButton = new JButton("Fahrt beenden");
        endRideButton.setBounds(40, 200, 200, 30);
        endRideButton.setEnabled(false);
        endRideButton.addActionListener(controller.EndRideListener());

        endTimeStampLabel = new JLabel("");
        endTimeStampLabel.setBounds(250, 200, 200, 30);

        duration = new JLabel("");
        duration.setBounds(40, 250, 400, 30);

        priceOutput = new JLabel("");
        priceOutput.setBounds(40, 300, 400, 30);

        JLabel activationLabel = new JLabel("Aktivierungsgebühr: 2 Eur");
        activationLabel.setBounds(40, 350, 200, 30);

        JLabel priceLabel = new JLabel("Preis pro Minute: 0,15 Eur");
        priceLabel.setBounds(40, 380, 200, 30);

        this.setSize(600, 600);
        this.setLayout(null);
        this.add(startRideButton);
        this.add(startTimeStampLabel);
        this.add(endTimeStampLabel);
        this.add(duration);
        this.add(endRideButton);
        this.add(priceOutput);
        this.add(goLabel);
        this.add(priceLabel);
        this.add(activationLabel);

    }

    /**
     * Sets the text of the price output label.
     * 
     * @param output the text of the price output.
     */
    public void setPriceOutput(String output) {
        priceOutput.setText(output);
    }

    /**
     * Sets the text of the start time label.
     * 
     * @param output the text of the start time label.
     */
    public void setStartTimeStampLabel(String output) {
        startTimeStampLabel.setText(output);
    }

    /**
     * Sets the text of the end time label.
     * 
     * @param output the text of the end time label.
     */
    public void setEndTimeStampLabel(String output) {
        endTimeStampLabel.setText(output);
    }

    /**
     * Sets the text of the ride duration label.
     * 
     * @param duration the text od the ride duration label.
     */
    public void setDurationLabel(String duration) {
        this.duration.setText(duration);
    }

    /**
     * Switches out the enabled buttons of the UI depending on whether a ride has
     * been started.
     * If a ride is started the start button will be disabled and the end button
     * enabled.
     * If a ride is ended the start button will be enabled and the button disabled.
     * 
     * @param isRideStarted if a ride is being started or ended.
     */
    public void switchButtonsEnabled(boolean isRideStarted) {
        this.endRideButton.setEnabled(isRideStarted);
        this.startRideButton.setEnabled(!isRideStarted);
    }
}
