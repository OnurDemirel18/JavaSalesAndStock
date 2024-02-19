package tr.com.onurdemirel.ui;

import tr.com.onurdemirel.dal.MusteriDal;
import tr.com.onurdemirel.dal.SehirDal;
import tr.com.onurdemirel.interfaces.UiI;
import tr.com.onurdemirel.types.MusteriContract;
import tr.com.onurdemirel.types.SehirContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SehirEkleCom extends JDialog implements UiI {
    public SehirEkleCom() {
        initPencere();
    }
    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Şehir Ekle"));
        add(panel);
        setTitle("Şehir Ekle");
        pack();
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(2,2));
        JLabel adLabel = new JLabel("Şehir Adı",JLabel.RIGHT);
        panel.add(adLabel);
        JTextField adField = new JTextField(10);
        panel.add(adField);

        JButton iptalButton = new JButton("İptal");
        panel.add(iptalButton);
        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);
        kaydetButton.addActionListener(e -> {
            SehirContract contract = new SehirContract();
            contract.setSehirAdi(adField.getText());

            new SehirDal().Insert(contract);
            JOptionPane.showMessageDialog(null, "Şehir Eklendi");
        });

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
