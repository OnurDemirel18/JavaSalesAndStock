package tr.com.onurdemirel.ui;

import tr.com.onurdemirel.dal.HesaplarDal;
import tr.com.onurdemirel.dal.PersonelDal;
import tr.com.onurdemirel.dal.YetkilerDal;
import tr.com.onurdemirel.interfaces.UiI;
import tr.com.onurdemirel.types.HesaplarContract;
import tr.com.onurdemirel.types.PersonelContract;
import tr.com.onurdemirel.types.Yetkiler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SifreBelirleCom extends JDialog implements UiI {

    public SifreBelirleCom() {
        initPencere();
    }

    @Override
    public void initPencere() {

        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Şifre Belirle"));
        add(panel);
        setTitle("Şifre Belirle");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(5,2));
        JLabel personelLabel = new JLabel("Personel", JLabel.RIGHT);
        panel.add(personelLabel);
        JComboBox personelBox = new JComboBox(new PersonelDal().GetAll().toArray());
        panel.add(personelBox);
        JLabel yetkiLabel = new JLabel("Yetki", JLabel.RIGHT);
        panel.add(yetkiLabel);
        JComboBox yetkiBox = new JComboBox(new YetkilerDal().GetAll().toArray());
        panel.add(yetkiBox);
        JLabel sifreLabel = new JLabel("Şifre", JLabel.RIGHT);
        panel.add(sifreLabel);
        JPasswordField sifreField = new JPasswordField(10);
        panel.add(sifreField);
        JLabel sifreTekrarLabel = new JLabel("Şifre Tekrar", JLabel.RIGHT);
        panel.add(sifreTekrarLabel);
        JPasswordField sifreTekrarField = new JPasswordField(10);
        panel.add(sifreTekrarField);
        JButton iptalButton = new JButton("İptal");
        panel.add(iptalButton);
        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HesaplarContract contract = new HesaplarContract();
                PersonelContract pContract = (PersonelContract) personelBox.getSelectedItem();
                Yetkiler yContract = (Yetkiler) yetkiBox.getSelectedItem();
                if (sifreField.getText().equals(sifreTekrarField.getText())) {
                    contract.setPersonelId(pContract.getPersonelId());
                    contract.setYetkiId(yContract.getYetkiId());
                    contract.setSifre(sifreField.getText());
                    new HesaplarDal().Insert(contract);
                    JOptionPane.showMessageDialog(null, "Şifre Belirlendi");
                } else {
                    JOptionPane.showMessageDialog(null, "Şifreler Uyuşmuyor");
                }




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
