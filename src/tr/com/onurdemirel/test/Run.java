package tr.com.onurdemirel.test;

import tr.com.onurdemirel.ui.MainWindowUi;

import javax.swing.*;

public class Run {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindowUi();
            }
        });
    }
}
