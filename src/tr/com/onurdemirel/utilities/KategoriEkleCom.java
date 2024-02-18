package tr.com.onurdemirel.utilities;

import tr.com.onurdemirel.dal.KategoriDal;
import tr.com.onurdemirel.interfaces.UiI;
import tr.com.onurdemirel.types.KategoriContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JPanel panel = new JPanel(new GridLayout(3, 2));



        JLabel adiLabel = new JLabel("Kategori Adı ", JLabel.RIGHT);
        panel.add(adiLabel);
        JTextField adiField = new JTextField(10);
        panel.add(adiField);

        JLabel kategoriLabel = new JLabel("Kategori ", JLabel.RIGHT);
        panel.add(kategoriLabel);

        JComboBox kategoriBox = new JComboBox(new KategoriDal().GetAllParentId().toArray());
        panel.add(kategoriBox);

        kategoriBox.insertItemAt("Kategori Seçiniz", 0);
        kategoriBox.setSelectedIndex(0);

        JButton iptalButton = new JButton("İptal");
        panel.add(iptalButton);

        JButton kaydetButton = new JButton("Kaydet");
        panel.add(kaydetButton);
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KategoriContract contract = new KategoriContract();


                if (kategoriBox.getSelectedIndex() != 0) {
                    KategoriContract casContract = (KategoriContract) kategoriBox.getSelectedItem();
                    contract.setKategoriAdi(adiField.getText());
                    contract.setParentId(casContract.getKategoriId());

                    new KategoriDal().Insert(contract);
                    JOptionPane.showMessageDialog(null, contract.getKategoriAdi() + " Kategorisi Eklendi");
                } else {
                    contract.setKategoriAdi(adiField.getText());
                    contract.setParentId(0);
                    new KategoriDal().Insert(contract);
                    JOptionPane.showMessageDialog(null, contract.getKategoriAdi() + " Kategorisi Eklendi");

                }
                kategoriBox.removeAllItems();
                kategoriBox.setModel(new DefaultComboBoxModel(new KategoriDal().GetAllParentId().toArray()));

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
