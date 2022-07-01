package scooteq.views;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import scooteq.controller.LoginController;

public class LoginPanel extends JPanel {
    private LoginController controller;
    private JTextField namefield;
    private JPasswordField passwordfield;
    private JLabel messagetext;

    public LoginPanel(MainView mainView){
        this.controller = new LoginController(mainView);
        this.init();
    }

    private void init() {
        JLabel title = new JLabel("Scooteq");
        title.setBounds(170, 50, 400, 30);

        namefield = new JTextField();
        namefield.setBounds(120, 120, 150, 20);

        passwordfield = new JPasswordField();
        passwordfield.setBounds(120, 170, 150, 20);

        JButton loginbutton = new JButton("Login");
        loginbutton.setBounds(95, 220, 200, 30);
        loginbutton.addActionListener(controller.LoginListener());

        messagetext = new JLabel();
        messagetext.setBounds(120, 270, 400, 30);

        this.setSize(600,600);
        this.setLayout(null);
        this.add(title);
        this.add(namefield);
        this.add(passwordfield);
        this.add(loginbutton);
        this.add(messagetext);
    }
    
    public void setMessage(String msg){
        messagetext.setText(msg);
    }

    public String getPassword() {
        return String.valueOf(this.passwordfield.getPassword());
    }

    public String getUsername() {
        return this.namefield.getText();
    }
}
