package login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    LoginModel model;
    LoginView view;

    public LoginController(LoginView v){
        this.view = v;
        this.model = new LoginModel();
    }

    public ActionListener LoginListener () {
         return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                //m.insertUser(new User(v.getName(), v.getPass()));
                if(model.loginUser(new User(view.getName(), view.getPass()))){
                    //view.setLoginVisible(false);

                }else{
                    view.setText("Login failed!");
                };
             }
         };
     }
}
