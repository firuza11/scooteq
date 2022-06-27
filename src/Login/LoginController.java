package Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    LoginModel m;
    public ActionListener LoginListener () {
         return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                m.doStuff();
             }
         };
     }
}
