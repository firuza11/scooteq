package scooteq.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import scooteq.model.User;
import scooteq.views.MainView;

public class LoginController{

    private MainView mainView;

    public LoginController(MainView mainView) {
        this.mainView = mainView;
    }

    public ActionListener LoginListener() {
        return new ActionListener() {
            @Override public void actionPerformed (ActionEvent e) {
               if(new User(mainView.getName(), mainView.getPass()).login()){
                    mainView.setLoginVisible(true);
               }else{
                   mainView.setText("Login failed!");
               };
            }
        };
    }
}