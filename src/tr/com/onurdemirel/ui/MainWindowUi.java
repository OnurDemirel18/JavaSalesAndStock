package tr.com.onurdemirel.ui;

import tr.com.onurdemirel.interfaces.UiI;
import tr.com.onurdemirel.utilities.MenulerCom;

import javax.swing.*;

public class MainWindowUi extends JFrame implements UiI {
    public MainWindowUi() {
        initPencere();
    }

    @Override
    public void initPencere() {

        JTabbedPane tabs = initTabs();
        JMenuBar bar = initBar();
        //add(tabs);
        setJMenuBar(bar);


        setTitle("Stok Takip Programı");
        setSize(800, 600);

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel();

        return panel;
    }

    @Override
    public JMenuBar initBar() {
        JMenuBar bar =new MenulerCom().initBar();
        return bar;
    }

    @Override
    public JTabbedPane initTabs() {
        return null;
    }
}
