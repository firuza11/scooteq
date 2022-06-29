package login;
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
                //m.insertUser(new User(v.getName(), v.getPass()));
                if(m.loginUser(new User(v.getName(), v.getPass()))){
                    v.setText("Login Successful!");
                }else{
                    v.setText("Login failed!");
                };
             }
         };
     }
}
