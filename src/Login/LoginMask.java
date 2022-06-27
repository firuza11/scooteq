import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginMask extends JFrame{

    public LoginMask(LoginView v, LoginController c) {
        this.setTitle("Login");
        final JTextField tf = new JTextField();
        tf.setBounds(50, 100, 150, 20);

        final JPasswordField pf = new JPasswordField();
        pf.setBounds(50, 100, 150, 20);

        JButton b = new JButton("Login");
        b.setBounds(50, 150, 200, 30);

        b.addActionListener(c.LoginListener());
        
        this.add(b);
        this.add(tf);
        this.add(pf);
        this.setSize(400, 600);
        this.setLayout(null);
    }
}
