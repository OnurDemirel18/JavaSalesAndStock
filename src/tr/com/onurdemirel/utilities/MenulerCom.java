package tr.com.onurdemirel.utilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenulerCom {
    public static JMenuBar initBar() {
        JMenuBar bar = new JMenuBar();
        JMenu dosyaMenu = new JMenu("Dosya");
        bar.add(dosyaMenu);
        JMenuItem cikisItem = new JMenuItem("Çıkış");
        dosyaMenu.add(cikisItem);

        JMenu urunMenu = new JMenu("Ürünler");
        bar.add(urunMenu);
        JMenuItem urunEkleItem = new JMenuItem("Ürün Ekle");
        urunMenu.add(urunEkleItem);
        JMenuItem kategoriEkleItem = new JMenuItem("Kategori Ekle");
        urunMenu.add(kategoriEkleItem);
        urunMenu.addSeparator();
        JMenuItem urunDuzenleItem = new JMenuItem("Ürün Düzenle");
        urunMenu.add(urunDuzenleItem);
        JMenuItem kategoriDuzenleItem = new JMenuItem("Kategori Düzenle");
        urunMenu.add(kategoriDuzenleItem);



        urunEkleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new UrunEkleCom();
                    }
                });
            }
        });

        kategoriEkleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new KategoriEkleCom();
                    }
                });
            }
        });

        return bar;
    }
}
