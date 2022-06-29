import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel{

    private MainController controller;
    private JLabel priceOutput;
    private JLabel startTimeStampLabel;
    private JLabel endTimeStampLabel;



    public MainPanel(MainController controller) {
        this.controller = controller;
        this.init();
    }

    private void init() {
        JLabel buttonName=new JLabel("Los geht's :)");
        buttonName.setBounds(50,100, 150,30);
        JButton startRideButton=new JButton("Start Ride");
        startRideButton.setBounds(50,150,200,30);
        JButton endRideButton=new JButton("End Ride");
        endRideButton.setBounds(50,200,200,30);
        priceOutput=new JLabel("");
        priceOutput.setBounds(50,250, 400,30);
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
