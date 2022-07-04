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
        loginpanel = new LoginPanel(this);
        loginpanel.init();
        loginpanel.setVisible(true);

        mainpanel = new MainPanel(this);
        mainpanel.init();
        mainpanel.setVisible(false);

        mainframe = new JFrame();
        mainframe.add(loginpanel);
        mainframe.add(mainpanel);

        mainframe.setTitle("Scooteq");
        mainframe.setSize(400, 600);
        mainframe.setLayout(null);
        mainframe.setVisible(true);

    }

    public void setLoginVisible(boolean isLoggedIn) {
        loginpanel.setVisible(false);
        mainpanel.setVisible(true);
    }

    public MainPanel getMainPanel() {
        return mainpanel;
    }

    public LoginPanel getLoginPanel() {
        return loginpanel;
    }
}
