package scooteq.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scooteq.model.User;
import scooteq.view.MainView;
import scooteq.view.panels.LoginPanel;

/**
 * This class controls the UI elements of the {@code LoginPanel} and contains
 * the listeners to control rides.
 * 
 * @see LoginPanel
 */
public class LoginController {

    private MainView mainView;
    private LoginPanel loginPanel;

    /**
     * Creates a new {@code MainController} from the {@code MainView} that is
     * attached to the {@code LoginPanel}
     * 
     * @param mainView the view that the controller is created from.
     */
    public LoginController(MainView mainView) {
        this.mainView = mainView;
        this.loginPanel = mainView.getLoginPanel();
    }

    /**
     * Logs a user into the app and sends an error message if the login fails.
     * 
     * @return the Listener to log in a user.
     * @see User
     */
    public ActionListener LoginListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (new User(loginPanel.getUsername(), loginPanel.getPassword()).login()) {
                        mainView.setLoginVisible(true);
                    } else {
                        loginPanel.setErrorMessage("Login fehlgeschlagen!");
                    }
                } catch (Exception ex) {
                    loginPanel.setErrorMessage("Fehler beim Encrypten des Passworts!");
                    ex.printStackTrace();
                }
            }
        };
    }
}