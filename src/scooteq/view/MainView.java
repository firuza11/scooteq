package scooteq.view;

import javax.swing.JFrame;

import scooteq.view.panels.LoginPanel;
import scooteq.view.panels.RidePanel;

/**
 * This class contains the mainframe of the app as well as panels that are added
 * to it.
 */
public class MainView {
    private JFrame mainframe;
    private LoginPanel loginpanel;
    private RidePanel ridePanel;

    /**
     * Creates a {@code JFrame} containing a {@code LoginPanel} and
     * {@code RidePanel}.
     */
    public MainView() {
        loginpanel = new LoginPanel(this);
        loginpanel.init();
        loginpanel.setVisible(true);

        ridePanel = new RidePanel(this);
        ridePanel.init();
        ridePanel.setVisible(false);

        mainframe = new JFrame();
        mainframe.add(loginpanel);
        mainframe.add(ridePanel);

        mainframe.setTitle("Scooteq");
        mainframe.setSize(400, 600);
        mainframe.setLayout(null);
        mainframe.setVisible(true);
    }

    /**
     * Disables the {@code LoginPanel} after a user has successfully logged in and
     * displays the {@code RidePanel} instead.
     * 
     * @param isLoggedIn
     */
    public void setLoginVisible(boolean isLoggedIn) {
        loginpanel.setVisible(false);
        ridePanel.setVisible(true);
    }

    /**
     * Returns the {@code RidePanel} of the app.
     * 
     * @return the RidePanel.
     */
    public RidePanel getRidePanel() {
        return ridePanel;
    }

    /**
     * Returns the {@code LoginPanel} of the app.
     * 
     * @return the LoginPanel.
     */
    public LoginPanel getLoginPanel() {
        return loginpanel;
    }
}
