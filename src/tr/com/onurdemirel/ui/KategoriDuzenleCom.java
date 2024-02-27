package tr.com.onurdemirel.ui;

import tr.com.onurdemirel.dal.KategoriDal;
import tr.com.onurdemirel.interfaces.UiI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KategoriDuzenleCom extends JDialog implements UiI {
    public KategoriDuzenleCom() {
        initPencere();
    }
    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        add(panel);
        setTitle("Kategori Düzenle");
        pack();
        setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel ustPanel = new JPanel(new GridLayout(3, 2));
        ustPanel.setBorder(BorderFactory.createTitledBorder("Kategori Düzenle"));
        JLabel kategoriAdiLabel = new JLabel("Kategori Adı", JLabel.RIGHT);
        ustPanel.add(kategoriAdiLabel);
        JTextField kategoriAdiField = new JTextField(10);
        ustPanel.add(kategoriAdiField);
        JLabel ustKategoriLabel = new JLabel("Üst Kategori", JLabel.RIGHT);
        ustPanel.add(ustKategoriLabel);
        JComboBox ustKategoriBox = new JComboBox(new KategoriDal().GetAll().toArray());
        ustPanel.add(ustKategoriBox);




        JList kategoriList = new JList();
        kategoriList.setListData(new KategoriDal().GetAll().toArray());
        JScrollPane scrollPane = new JScrollPane(kategoriList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Kategoriler"));
        kategoriAdiField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

                kategoriList.setListData(new KategoriDal().GetSearchKategori(kategoriAdiField.getText()).toArray());
                kategoriList.setSelectedIndex(0);
            }
        });

        panel.add(ustPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

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
