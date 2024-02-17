package tr.com.onurdemirel.utilities;

import tr.com.onurdemirel.interfaces.UiI;

import javax.swing.*;
import java.awt.*;

public class KategoriEkleCom extends JDialog implements UiI {
    public KategoriEkleCom() {
        initPencere();
    }
    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Kategori Ekle"));
        add(panel);
        setTitle("Kategori Ekle");
        pack();
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setVisible(true);

        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2));

        JLabel adiLabel = new JLabel("Kategori Adı ", JLabel.RIGHT);
        panel.add(adiLabel);
        JTextField adiField = new JTextField(10);
        panel.add(adiField);

        JButton iptalButton = new JButton("İptal");
        panel.add(iptalButton);

        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);





        return panel;
    }

    @Override
    public JMenuBar initBar() {
        return null;
    }

    @Override
    public JTabbedPane initTabs() {
        return null;
    }
}
