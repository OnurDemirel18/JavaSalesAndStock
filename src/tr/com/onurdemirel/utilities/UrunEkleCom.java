package tr.com.onurdemirel.utilities;

import com.toedter.calendar.JDateChooser;
import tr.com.onurdemirel.interfaces.UiI;

import javax.swing.*;
import java.awt.*;

public class UrunEkleCom extends JDialog implements UiI {
    public UrunEkleCom() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Ürün Ekle"));
        add(panel);
        setTitle("Ürün Ekle");
        pack();
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);
        setVisible(true);

        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));

        JLabel adiLabel = new JLabel("Ürün Adı ", JLabel.RIGHT);
        panel.add(adiLabel);

        JTextField adiField = new JTextField(10);
        panel.add(adiField);

        JLabel kategoriLabel = new JLabel("Kategori ", JLabel.RIGHT);
        panel.add(kategoriLabel);

        JComboBox kategoriBox = new JComboBox();
        panel.add(kategoriBox);

        JLabel tarihLabel = new JLabel("Tarih", JLabel.RIGHT);
        panel.add(tarihLabel);

        JDateChooser tarihChooser = new JDateChooser();
        panel.add(tarihChooser);

        JLabel fiyatLabel = new JLabel("Fiyat", JLabel.RIGHT);
        panel.add(fiyatLabel);

        JTextField fiyatField = new JTextField(10);
        panel.add(fiyatField);

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
