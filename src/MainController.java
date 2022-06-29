import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import login.LoginModel;
import login.User;

public class MainController {

    private MainView mainView;
    private LoginModel loginModel;
    private Ride ride;

    public MainController(MainView mainView) {
        this.mainView = mainView;
        this.loginModel = new LoginModel();
        this.ride = new Ride();
    }

    public ActionListener LoginListener() {
        return new ActionListener() {
            @Override public void actionPerformed (ActionEvent e) {
               if(loginModel.loginUser(new User(mainView.getName(), mainView.getPass()))){
                    mainView.setLoginVisible(true);
               }else{
                   mainView.setText("Login failed!");
               };
            }
        };
    }

    public ActionListener StartRideListener() {
        return new ActionListener() {
            @Override public void actionPerformed (ActionEvent e) {
                try {
                    ride.start();
                    mainView.setStartTimeStampLabel(ride.getTimeOfRideStartInMilliseconds().toString());
                    mainView.setPriceOutput("Finish the ride to calculate the price...");
                } catch (Exception ex) {
                };
            }
        };
    }

    public ActionListener EndRideListener() {
        return new ActionListener() {
            @Override public void actionPerformed (ActionEvent e) {
                try {
                    ride.end();
                    ride.calculateDurationInSeconds();
                    ride.calculatePrice();
                    mainView.setPriceOutput(String.valueOf("Fahrpreis: " + ride.getRidePrice() + " Eur"));
                    mainView.setEndTimeStampLabel(ride.getTimeOfRideEndInMilliseconds().toString());
                } catch (Exception ex) {
                }
            }
        };
    }

}
