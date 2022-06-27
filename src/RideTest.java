import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class RideTest {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Ride theRide = new Ride();
        JFrame mainFrame=new JFrame("Fahrpreis kalkulieren...");
        JLabel buttonName=new JLabel("Nutzdauer in Minuten..:");
        buttonName.setBounds(50,50, 150,30);
        JButton startRideButton=new JButton("Start Ride");
        startRideButton.setBounds(50,150,200,30);
        JButton endRideButton=new JButton("End Ride");
        endRideButton.setBounds(50,200,200,30);
        JLabel priceOutput=new JLabel("Bitte zuerst die Nutzdauer eingeben...");
        priceOutput.setBounds(50,250, 400,30);
        startRideButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    theRide.start();
                   priceOutput.setText("Hello");
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
                } catch (Exception ex) {
                }
            }
        });

        mainFrame.add(startRideButton);
        mainFrame.add(endRideButton);
        mainFrame.add(priceOutput);mainFrame.add(buttonName);
        mainFrame.setSize(400,600);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }
}
