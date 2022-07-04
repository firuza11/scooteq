package scooteq.view.panels;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import scooteq.controller.LoginController;
import scooteq.view.MainView;

/**
 * This class contains the UI elements to login into the scooteq app.
 * {@code MainController}.
 * 
 * @see LoginController
 */
public class LoginPanel extends JPanel {
    private LoginController controller;
    private JTextField namefield;
    private JPasswordField passwordfield;
    private JLabel errorMessage;
    private MainView mainView;

    /**
     * Creates a new LoginPanel from the {@code MainView}.
     * 
     * @param mainView the view that the panel will be added to.
     */
    public LoginPanel(MainView mainView) {
        this.mainView = mainView;
    }

    /**
     * Initializes the UI elements of the panel including the {@code LoginListener}.
     */
    public void init() {
        this.controller = new LoginController(mainView);
        JLabel title = new JLabel("Scooteq");
        title.setBounds(170, 50, 400, 30);

        namefield = new JTextField();
        namefield.setBounds(120, 120, 150, 20);

        passwordfield = new JPasswordField();
        passwordfield.setBounds(120, 170, 150, 20);

        JButton loginbutton = new JButton("Login");
        loginbutton.setBounds(95, 220, 200, 30);
        loginbutton.addActionListener(controller.LoginListener());

        errorMessage = new JLabel();
        errorMessage.setBounds(120, 270, 400, 30);

        this.setSize(600, 600);
        this.setLayout(null);
        this.add(title);
        this.add(namefield);
        this.add(passwordfield);
        this.add(loginbutton);
        this.add(errorMessage);
    }

    /**
     * Sets the the text of the error message in case a login goes wrong.
     * 
     * @param message the error text to be displayed.
     */
    public void setErrorMessage(String message) {
        errorMessage.setText(message);
    }

    /**
     * Returns the entered password.
     * 
     * @return the entered password.
     */
    public String getPassword() {
        return String.valueOf(this.passwordfield.getPassword());
    }

    /**
     * Returns the entered username.
     * 
     * @return the entered username.
     */
    public String getUsername() {
        return this.namefield.getText();
    }
}
