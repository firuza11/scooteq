package Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    LoginModel m;
    LoginView v;

    public LoginController(LoginView v){
        this.v = v;
        this.m = new LoginModel();
    }

    public ActionListener LoginListener () {
         return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                m.doStuff();
             }
         };
     }
}
