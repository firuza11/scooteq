package scooteq.views;

import javax.swing.JFrame;

public class MainView {
    private JFrame mainframe;
    private LoginPanel loginpanel;
    private MainPanel mainpanel;

    public MainView() {
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

    public void setLoginVisible(boolean isLoggedIn) {
        this.loginpanel.setVisible(false);
        this.mainpanel.setVisible(true);
    }

    public MainPanel getMainPanel() {
        return this.mainpanel;
    }

    public LoginPanel getLoginPanel() {
        return this.getLoginPanel();
    }
}
