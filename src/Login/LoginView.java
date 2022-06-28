package Login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView {
    private LoginController c;
    public LoginView() { 
        c = new LoginController(this);
        init();
    }

    private void init(){
        JFrame frame = new JFrame();
        frame.setTitle("Login");
        final JTextField tf = new JTextField();
        tf.setBounds(50, 100, 150, 20);

        final JPasswordField pf = new JPasswordField();
        pf.setBounds(50, 150, 150, 20);

        JButton b = new JButton("Login");
        b.setBounds(50, 200, 200, 30);
        tf.setHorizontalAlignment(JTextField.CENTER);

        b.addActionListener(c.LoginListener());
        
        frame.add(b);
        frame.add(tf);
        frame.add(pf);
        frame.setSize(400, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
