package scooteq;

import javax.swing.SwingUtilities;

import scooteq.view.MainView;

/**
 * The Main class of the scooteq app. It creates a new {@code MainView}.
 */
public class App {
    
    /** 
     * @param args the arguments passed for the execution
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainView();
            }
        });
    }
}
