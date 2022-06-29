package scooteq;

import javax.swing.SwingUtilities;

import scooteq.views.MainView;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainView();
            }
        });
    }
}
