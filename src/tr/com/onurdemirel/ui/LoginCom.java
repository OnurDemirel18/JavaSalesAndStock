package tr.com.onurdemirel.ui;

import tr.com.onurdemirel.dal.HesaplarDal;
import tr.com.onurdemirel.dal.PersonelDal;
import tr.com.onurdemirel.interfaces.UiI;
import tr.com.onurdemirel.types.PersonelContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginCom extends JDialog implements UiI {
    public static JComboBox emailBox;
    public LoginCom() {
        initPencere();
    }

    public void initPencere() {
        JPanel panel = initPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Giriş Ekranı"));
        add(panel);


        setTitle("Giriş Ekranı");
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(3,2));

        JLabel emailLabel = new JLabel("E-Mail",JLabel.RIGHT);
        panel.add(emailLabel);
        emailBox = new JComboBox(new PersonelDal().GetAll().toArray());
        panel.add(emailBox);
        JLabel sifreLabel = new JLabel("Şifre",JLabel.RIGHT);
        panel.add(sifreLabel);
        JPasswordField sifreField = new JPasswordField();
        panel.add(sifreField);

        JButton iptalButton = new JButton("İptal");
        panel.add(iptalButton);
        JButton girisButton = new JButton("Giriş");
        panel.add(girisButton);

        girisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PersonelContract contract = (PersonelContract) emailBox.getSelectedItem();
                if(new HesaplarDal().GetPersonelIdVeSifre(contract.getPersonelId(),sifreField.getText()).getHesapId()!= 0 ) {
                    new MainWindowUi();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Şifre hatalı");
                }
            }
        });

        iptalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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
