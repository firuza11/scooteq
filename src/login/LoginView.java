package login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView {
    private LoginController controller;
    private JTextField tf;
    private JPasswordField pf;
    private JLabel txt;
    private JFrame frame;

    public LoginView() {
        controller = new LoginController(this);
        init();
    }

    private void init() {
        frame = new JFrame();
        frame.setTitle("Login");
        tf = new JTextField();
        tf.setBounds(50, 100, 150, 20);

        pf = new JPasswordField();
        pf.setBounds(50, 150, 150, 20);

        JButton b = new JButton("Login");
        b.setBounds(50, 200, 200, 30);
        tf.setHorizontalAlignment(JTextField.CENTER);

        b.addActionListener(controller.LoginListener());

        txt = new JLabel();
        txt.setBounds(50, 250, 400, 30);

        frame.add(b);
        frame.add(tf);
        frame.add(pf);
        frame.add(txt);
        frame.setSize(400, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public String getPass() {
        return String.valueOf(this.pf.getPassword());
    }

    public String getName() {
        return this.tf.getText();
    }

    public void setText(String txt) {
        this.txt.setText(txt);
    }

    public void setLognVisible(boolean b){
        frame.setVisible(b);
    }
}
