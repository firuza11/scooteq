
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import login.LoginPanel;

public class MainView {
    private MainController controller;
    private JFrame mainframe;
    private LoginPanel loginpanel;
    private MainPanel mainpanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainView();
            }
        });
    }

    public MainView(){
        this.controller = new MainController(this);
        this.init();
    }

    private void init() {
        mainframe = new JFrame();
        this.loginpanel = new LoginPanel(controller);
        this.mainpanel = new MainPanel(controller);
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
}
