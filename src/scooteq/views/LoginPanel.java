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
        tf = new JTextField();
        tf.setBounds(50, 100, 150, 20);

        pf = new JPasswordField();
        pf.setBounds(50, 150, 150, 20);

        JButton b = new JButton("Login");
        b.setBounds(50, 200, 200, 30);
        b.addActionListener(controller.LoginListener());

        txt = new JLabel();
        txt.setBounds(50, 250, 400, 30);

        this.setSize(600,600);
        this.setLayout(null);
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
