package tr.com.onurdemirel.ui;

import tr.com.onurdemirel.dal.YetkilerDal;
import tr.com.onurdemirel.interfaces.UiI;
import tr.com.onurdemirel.types.Yetkiler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YetkiEkleCom extends JDialog implements UiI {
    public YetkiEkleCom() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);

        setTitle("Yetki Ekle");
        pack();
        setModalityType(DEFAULT_MODALITY_TYPE);
        setLocationRelativeTo(null);

        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new GridLayout(2,2));
        panel.setBorder(BorderFactory.createTitledBorder("Yetki Ekle"));
        JLabel adLabel = new JLabel("Yetki Adı",JLabel.RIGHT);
        panel.add(adLabel);
        JTextField adField = new JTextField(10);
        panel.add(adField);

        JButton iptalButton = new JButton("İptal");
        panel.add(iptalButton);
        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Yetkiler contract = new Yetkiler();

                contract.setYetkiAdi(adField.getText());
                new YetkilerDal().Insert(contract);
                JOptionPane.showMessageDialog(null,"Yetki Eklendi");
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
