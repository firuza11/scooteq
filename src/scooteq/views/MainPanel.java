package scooteq.views;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scooteq.controller.MainController;

public class MainPanel extends JPanel{

    private MainController controller;
    private JLabel priceOutput;
    private JLabel startTimeStampLabel;
    private JLabel endTimeStampLabel;
    private JLabel duration;
    private JButton endRideButton;
    private JButton startRideButton;



    public MainPanel(MainView mainView) {
        this.controller = new MainController(mainView);
        this.init();
    }

    private void init() {
        JLabel buttonName=new JLabel("Los geht's :)");
        buttonName.setBounds(40,100, 150,30);

        startRideButton=new JButton("Fahrt starten");
        startRideButton.setBounds(40,150,200,30);

        startTimeStampLabel=new JLabel("");
        startTimeStampLabel.setBounds(250, 150, 200, 30);

        endRideButton=new JButton("Fahrt beenden");
        endRideButton.setBounds(40,200,200,30);
        endRideButton.setEnabled(false);

        endTimeStampLabel=new JLabel("");
        endTimeStampLabel.setBounds(250, 200, 200, 30);

        duration = new JLabel("");
        duration.setBounds(40,250, 400,30);
        
        priceOutput=new JLabel("");
        priceOutput.setBounds(40,300, 400,30);

        JLabel activationLabel = new JLabel("Aktivierungsgebühr: 2 Eur");
        activationLabel.setBounds(40, 350, 200, 30);

        JLabel priceLabel = new JLabel("Preis pro Minute: 0,15 Eur");
        priceLabel.setBounds(40, 380, 200, 30);

        this.setSize(600,600);
        this.setLayout(null);

        startRideButton.addActionListener(controller.StartRideListener());
        endRideButton.addActionListener(controller.EndRideListener());

        this.add(startRideButton);
        this.add(startTimeStampLabel);
        this.add(endTimeStampLabel);
        this.add(duration);
        this.add(endRideButton);
        this.add(priceOutput);
        this.add(buttonName);
        this.add(priceLabel);
        this.add(activationLabel);

    }

    public void setPriceOutput(String output){
        priceOutput.setText(output);
    }

    public void setStartTimeStampLabel(String output) {
        startTimeStampLabel.setText(output);
    }

    public void setEndTimeStampLabel(String output) {
        endTimeStampLabel.setText(output);
    }

    public void setDurationLabel(String duration) {
        this.duration.setText(duration);
    }

    public void switchButtonsEnabled(boolean enabled) {
        this.endRideButton.setEnabled(enabled);
        this.startRideButton.setEnabled(!enabled);
    }
}
