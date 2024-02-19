package tr.com.onurdemirel.ui;

import com.toedter.calendar.JDateChooser;
import tr.com.onurdemirel.dal.KategoriDal;
import tr.com.onurdemirel.interfaces.UiI;
import tr.com.onurdemirel.types.KategoriContract;
import tr.com.onurdemirel.types.UrunlerContract;
import tr.com.onurdemirel.dal.UrunlerDal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

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

        JComboBox kategoriBox = new JComboBox(new KategoriDal().GetAll().toArray());
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
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UrunlerContract contract = new UrunlerContract();
                KategoriContract casContract = (KategoriContract) kategoriBox.getSelectedItem();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String date = format.format(tarihChooser.getDate());
                contract.setUrunAdi(adiField.getText());
                contract.setUrunKategoriId(casContract.getKategoriId());
                contract.setUrunTarih(java.sql.Date.valueOf(date));
                contract.setUrunFiyat(Float.parseFloat(fiyatField.getText()));


                new UrunlerDal().Insert(contract);
                JOptionPane.showMessageDialog(null, contract.getUrunAdi() + " Ürünü Eklendi");
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
