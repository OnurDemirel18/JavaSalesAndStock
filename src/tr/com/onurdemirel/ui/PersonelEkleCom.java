package tr.com.onurdemirel.ui;

import tr.com.onurdemirel.dal.PersonelDal;
import tr.com.onurdemirel.interfaces.UiI;
import tr.com.onurdemirel.types.PersonelContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonelEkleCom extends JDialog implements UiI {
    public PersonelEkleCom() {
        initPencere();

    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();

        add(panel);

        setTitle("Personel Ekle");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.setBorder(BorderFactory.createTitledBorder("Personel Ekle") );
        JLabel adiSoyadiLabel = new JLabel("Adı Soyadı: ", JLabel.RIGHT);
        panel.add(adiSoyadiLabel);
        JTextField adiSoyadiField = new JTextField(10);
        panel.add(adiSoyadiField);
        JLabel emailLabel = new JLabel("Email: ", JLabel.RIGHT);
        panel.add(emailLabel);
        JTextField emailField = new JTextField(10);
        panel.add(emailField);

        JButton iptalButton = new JButton("İptal");
        panel.add(iptalButton);
        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);

        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonelContract contract = new PersonelContract();
                contract.setPersonelAdSoyad(adiSoyadiField.getText());
                contract.setEmail(emailField.getText());

                new PersonelDal().Insert(contract);
                JOptionPane.showMessageDialog(null, "Personel Eklendi");
            }
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
