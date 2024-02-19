package tr.com.onurdemirel.utilities;

import tr.com.onurdemirel.ui.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenulerCom {
    public static JMenuBar initBar() {
        // Menü barı oluşturuluyor
        JMenuBar bar = new JMenuBar();
        //Dosya Menüsü
        JMenu dosyaMenu = new JMenu("Dosya");
        bar.add(dosyaMenu);
        JMenuItem cikisItem = new JMenuItem("Çıkış");
        dosyaMenu.add(cikisItem);

        //Ürün Menüsü
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

        //Personel Menüsü
        JMenu personellerMenu = new JMenu("Personeller");
        bar.add(personellerMenu);
        JMenuItem personelEkleItem = new JMenuItem("Personel Ekle");
        personellerMenu.add(personelEkleItem);
        JMenuItem yetkiEkleItem = new JMenuItem("Yetki Ekle");
        personellerMenu.add(yetkiEkleItem);
        JMenuItem sifreBelirleItem = new JMenuItem("Şifre Belirle");
        personellerMenu.add(sifreBelirleItem);
        personellerMenu.addSeparator();
        JMenuItem personelDuzenleItem = new JMenuItem("Personel Düzenle");
        personellerMenu.add(personelDuzenleItem);
        JMenuItem yetkiDuzenleItem = new JMenuItem("Yetki Düzenle");
        personellerMenu.add(yetkiDuzenleItem);
        JMenuItem sifreDuzenleItem = new JMenuItem("Şifre Düzenle");
        personellerMenu.add(sifreDuzenleItem);

        JMenu musteriMenu = new JMenu("Müşteriler");
        bar.add(musteriMenu);
        JMenuItem musteriEkleItem = new JMenuItem("Müşteri Ekle");
        musteriMenu.add(musteriEkleItem);
        JMenuItem sehirEkleItem = new JMenuItem("Şehir Ekle");
        musteriMenu.add(sehirEkleItem);
        musteriMenu.addSeparator();
        JMenuItem musteriDuzenleItem = new JMenuItem("Müşteri Düzenle");
        musteriMenu.add(musteriDuzenleItem);
        JMenuItem sehirDuzenleItem = new JMenuItem("Şehir Düzenle");
        musteriMenu.add(sehirDuzenleItem);





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

        personelEkleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new PersonelEkleCom();
                    }
                });
            }
        });

        yetkiEkleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new YetkiEkleCom();
                    }
                });
            }
        });

        sifreBelirleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SifreBelirleCom();
            }
        });

        musteriEkleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new MusteriEkleCom();
                    }
                });
            }
        });

        sehirEkleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new SehirEkleCom();
                    }
                });
            }
        });

        return bar;
    }
}
