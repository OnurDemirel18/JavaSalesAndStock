package tr.com.onurdemirel.ui;

import tr.com.onurdemirel.dal.MusteriDal;
import tr.com.onurdemirel.dal.SehirDal;
import tr.com.onurdemirel.interfaces.UiI;
import tr.com.onurdemirel.types.MusteriContract;

import javax.swing.*;
import java.awt.*;

public class MusteriEkleCom extends JDialog implements UiI {
    public MusteriEkleCom() {
        initPencere();
    }

    @Override
    public void initPencere() {

        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Müşteri Ekle"));
        add(panel);
        setTitle("Müşteri Ekle");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel fieldPanel = new JPanel(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(5, 2));
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

        JLabel adiSoyadiLabel = new JLabel("Adı Soyadı: ", JLabel.RIGHT);
        panel.add(adiSoyadiLabel);
        JTextField adiSoyadiField = new JTextField(10);
        panel.add(adiSoyadiField);
        JLabel telefonLabel = new JLabel("Telefon: ", JLabel.RIGHT);
        panel.add(telefonLabel);
        JTextField telefonField = new JTextField(10);
        panel.add(telefonField);
        JLabel sehirLabel = new JLabel("Şehir: ", JLabel.RIGHT);
        panel.add(sehirLabel);
        JComboBox sehirBox = new JComboBox(new SehirDal().GetAll().toArray());
        panel.add(sehirBox);
        JTextArea adresField = new JTextArea(5,1);

        JScrollPane pane = new JScrollPane(adresField);
        pane.setBorder(BorderFactory.createTitledBorder("Adres"));





        JButton iptalButton = new JButton("İptal");
        buttonPanel.add(iptalButton);
        JButton kaydetButton = new JButton("Kaydet");
        buttonPanel.add(kaydetButton);
        kaydetButton.addActionListener(e -> {
            MusteriContract contract = new MusteriContract();
            contract.setMusteriAdiSoyadi(adiSoyadiField.getText());
            contract.setMusteriTelefon(telefonField.getText());
            contract.setMusteriAdres(adresField.getText());

            new MusteriDal().Insert(contract);
            JOptionPane.showMessageDialog(null, "Müşteri Eklendi");
        });

        iptalButton.addActionListener(e -> {
            setVisible(false);
        });

        fieldPanel.add(panel, BorderLayout.NORTH);
        fieldPanel.add(pane, BorderLayout.CENTER);
        fieldPanel.add(buttonPanel, BorderLayout.SOUTH);

        return fieldPanel;
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
