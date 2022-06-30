package scooteq.views;

import javax.swing.JFrame;


public class MainView {
    private JFrame mainframe;
    private LoginPanel loginpanel;
    private MainPanel mainpanel;

    public MainView(){
        this.init();
    }

    private void init() {
        mainframe = new JFrame();
        this.loginpanel = new LoginPanel(this);
        this.mainpanel = new MainPanel(this);
        mainframe.add(loginpanel);
        mainframe.add(mainpanel);
        
        mainframe.setTitle("Scooteq");
        mainframe.setSize(400, 600);
        mainframe.setLayout(null);
        loginpanel.setVisible(true);
        mainpanel.setVisible(false);
        mainframe.setVisible(true);
        
    }

    public void setText(String msg) {
        loginpanel.setText(msg);
    }

    public String getPass() {
        return loginpanel.getPass();
    }

    public String getName() {
        return loginpanel.getName();
    }

    public void setLoginVisible(boolean isLoggedIn){
        this.loginpanel.setVisible(false);
        this.mainpanel.setVisible(true);
    }

    public void setPriceOutput(String output){
        this.mainpanel.setPriceOutput(output);
    }

    
    public void setStartTimeStampLabel(String output){
        this.mainpanel.setStartTimeStampLabel(output);
    }

    public void setEndTimeStampLabel(String output){
        this.mainpanel.setEndTimeStampLabel(output);
    }

    public void setDuration(String durationInMinutes) {
        this.mainpanel.setDurationLabel(durationInMinutes);
    }

    public void setEndButtonEnabled(boolean enabled) {
        this.mainpanel.setEndButtonEnabled(enabled);
    }
}
