import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Test
{
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        JFrame f=new JFrame("Fahrpreis kalkulieren...");
        JLabel buttonName=new JLabel("Nutzdauer in Minuten..:");
        buttonName.setBounds(50,50, 150,30);
        final JTextField tf=new JTextField();
        tf.setBounds(50,100, 150,20);
        JButton b=new JButton("Fahrpreis kalkulieren...");
        b.setBounds(50,150,200,30);
        JLabel priceOutput=new JLabel("Bitte zuerst die Nutzdauer eingeben...");
        priceOutput.setBounds(50,200, 400,30);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    double finalPriceCalc = Integer.parseInt(tf.getText()) * 0.15;
                    priceOutput.setText(String.valueOf("Fahrpreis: " + df.format(finalPriceCalc) + " Eur"));
                } catch (Exception ex) {
                    JFrame errorFrame = new JFrame("Fehler");
                    JLabel errorMessage = new JLabel("Fehler: Bitte nur Minuten eingeben...");
                    errorMessage.setBounds(50,50,250, 30);
                    errorFrame.add(errorMessage);
                    errorFrame.setSize(400,200);
                    errorFrame.setLayout(null);
                    errorFrame.setVisible(true);
                    priceOutput.setText("Bitte zuerst die Nutzdauer in Minuten eingeben...");
                }
            }
        });
        f.add(b);f.add(tf);f.add(priceOutput);f.add(buttonName);
        f.setSize(400,600);
        f.setLayout(null);
        f.setVisible(true);
    }
}
