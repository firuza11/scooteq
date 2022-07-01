package scooteq.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scooteq.model.User;
import scooteq.views.MainView;

public class LoginController {

    private MainView mainView;

    public LoginController(MainView mainView) {
        this.mainView = mainView;
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
                    if (new User(mainView.getUsername(), mainView.getPassword()).login()) {
                        mainView.setLoginVisible(true);
                    } else {
                        mainView.setText("Login fehlgeschlagen!");
                    }
                } catch (Exception ex) {
                    mainView.setText("Fehler beim Encrypten des Passworts!");
                    ex.printStackTrace();
                }
                ;
            }
        };
    }
}