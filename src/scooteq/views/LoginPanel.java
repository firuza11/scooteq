package scooteq.views;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import scooteq.controller.LoginController;

public class LoginPanel extends JPanel {
    private LoginController controller;
    private JTextField tf;
    private JPasswordField pf;
    private JLabel txt;

    public LoginPanel(MainView mainView){
        this.controller = new LoginController(mainView);
        this.init();
    }

    private void init() {
        JLabel title = new JLabel("Scooteq");
        title.setBounds(170, 50, 400, 30);

        tf = new JTextField();
        tf.setBounds(120, 120, 150, 20);

        pf = new JPasswordField();
        pf.setBounds(120, 170, 150, 20);

        JButton b = new JButton("Login");
        b.setBounds(95, 220, 200, 30);
        b.addActionListener(controller.LoginListener());

        txt = new JLabel();
        txt.setBounds(120, 270, 400, 30);

        this.setSize(600,600);
        this.setLayout(null);
        this.add(title);
        this.add(tf);
        this.add(pf);
        this.add(b);
        this.add(txt);
    }
    
    public void setText(String msg){
        txt.setText(msg);
    }

    public String getPass() {
        return String.valueOf(this.pf.getPassword());
    }

    public String getName() {
        return this.tf.getText();
    }
}
