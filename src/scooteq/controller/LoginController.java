package scooteq.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scooteq.model.User;
import scooteq.views.LoginPanel;
import scooteq.views.MainView;

public class LoginController {

    private MainView mainView;
    private LoginPanel loginPanel;

    public LoginController(MainView mainView) {
        this.mainView = mainView;
        this.loginPanel = mainView.getLoginPanel();
    }

    /**
     * 
     * @return 
     */
    public ActionListener LoginListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (new User(loginPanel.getUsername(), loginPanel.getPassword()).login()) {
                        mainView.setLoginVisible(true);
                    } else {
                        loginPanel.setMessage("Login fehlgeschlagen!");
                    }
                } catch (Exception ex) {
                    loginPanel.setMessage("Fehler beim Encrypten des Passworts!");
                    ex.printStackTrace();
                }
                ;
            }
        };
    }
}