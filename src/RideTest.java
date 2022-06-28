import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class RideTest {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Ride theRide = new Ride();
        JFrame mainFrame=new JFrame("Fahrpreis kalkulieren...");
        JLabel buttonName=new JLabel("Los geht's :)");
        buttonName.setBounds(50,100, 150,30);
        JButton startRideButton=new JButton("Start Ride");
        startRideButton.setBounds(50,150,200,30);
        JButton endRideButton=new JButton("End Ride");
        endRideButton.setBounds(50,200,200,30);
        JLabel priceOutput=new JLabel("");
        priceOutput.setBounds(50,250, 400,30);
        JLabel startTimeStampLabel=new JLabel("");
        startTimeStampLabel.setBounds(300, 150, 200, 30);
        JLabel endTimeStampLabel=new JLabel("");
        endTimeStampLabel.setBounds(300, 200, 200, 30);

        startRideButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    theRide.start();
                    startTimeStampLabel.setText(theRide.getTimeOfRideStartInMilliseconds().toString());
                    priceOutput.setText("Finish the ride to calculate the price...");
                } catch (Exception ex) {
                }
            }
        });

        endRideButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    theRide.end();
                    theRide.calculateDurationInSeconds();
                    theRide.calculatePrice();
                    priceOutput.setText(String.valueOf("Fahrpreis: " + theRide.getRidePrice() + " Eur"));
                    endTimeStampLabel.setText(theRide.getTimeOfRideEndInMilliseconds().toString());
                } catch (Exception ex) {
                }
            }
        });

        mainFrame.add(startRideButton);
        mainFrame.add(startTimeStampLabel);
        mainFrame.add(endTimeStampLabel);
        mainFrame.add(endRideButton);
        mainFrame.add(priceOutput);
        mainFrame.add(buttonName);
        mainFrame.setSize(600,600);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }
}
