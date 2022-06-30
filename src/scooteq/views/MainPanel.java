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



    public MainPanel(MainView mainView) {
        this.controller = new MainController(mainView);
        this.init();
    }

    private void init() {
        JLabel buttonName=new JLabel("Los geht's :)");
        buttonName.setBounds(40,100, 150,30);
        JButton startRideButton=new JButton("Fahrt starten");
        startRideButton.setBounds(40,150,200,30);
        JButton endRideButton=new JButton("Fahrt beenden");
        endRideButton.setBounds(40,200,200,30);
        priceOutput=new JLabel("");
        priceOutput.setBounds(40,250, 400,30);
        startTimeStampLabel=new JLabel("");
        startTimeStampLabel.setBounds(250, 150, 200, 30);
        endTimeStampLabel=new JLabel("");
        endTimeStampLabel.setBounds(250, 200, 200, 30);

        this.setSize(600,600);
        this.setLayout(null);

        startRideButton.addActionListener(controller.StartRideListener());
        endRideButton.addActionListener(controller.EndRideListener());

        this.add(startRideButton);
        this.add(startTimeStampLabel);
        this.add(endTimeStampLabel);
        this.add(endRideButton);
        this.add(priceOutput);
        this.add(buttonName);

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
}
