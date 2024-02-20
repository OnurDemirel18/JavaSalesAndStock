package tr.com.onurdemirel.ui;

import com.toedter.calendar.JDateChooser;
import tr.com.onurdemirel.interfaces.UiI;
import tr.com.onurdemirel.utilities.MenulerCom;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainWindowUi extends JFrame implements UiI {
    public MainWindowUi() {
        initPencere();
    }

    @Override
    public void initPencere() {
        JPanel panel = initPanel();
        JTabbedPane tabs = initTabs();
        JMenuBar bar = initBar();
        //add(tabs);
        add(panel);
        setJMenuBar(bar);


        setTitle("Stok Takip Programı");
        setSize(800, 600);

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public JPanel initPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTabbedPane tabs = initTabs();
        panel.add(tabs,BorderLayout.CENTER);
        return panel;
    }

    @Override
    public JMenuBar initBar() {
        JMenuBar bar =new MenulerCom().initBar();
        return bar;
    }

    @Override
    public JTabbedPane initTabs() {
        JTabbedPane pane = new JTabbedPane();
        ImageIcon icon = new ImageIcon("icons/stocks48.png");

        JPanel stokPanel = new JPanel(new BorderLayout());
        JPanel satisPanel = new JPanel(new BorderLayout());

        //Stok İşlemleri
        JPanel stokSolPanel = new JPanel(new BorderLayout());
        JPanel stokSolUstPanel = new JPanel(new GridLayout(4,2));
        JPanel stokSolAltPanel = new JPanel();
        stokSolPanel.setBorder(BorderFactory.createTitledBorder("Stoklar"));
        String[] stokKolonlar = {"Id","Personel Ad","Ürün Ad","Adet","Tarih"};
        DefaultTableModel model = new DefaultTableModel(stokKolonlar,0);
        JTable table = new JTable(model);
        JScrollPane stokTablePane = new JScrollPane(table);

        JLabel stokUrunAdiLabel = new JLabel("Ürün Adı",JLabel.RIGHT);
        stokSolUstPanel.add(stokUrunAdiLabel);
        JComboBox stokUrunAdiBox = new JComboBox();
        stokSolUstPanel.add(stokUrunAdiBox);
        JLabel stokAdetLabel = new JLabel("Adet",JLabel.RIGHT);
        stokSolUstPanel.add(stokAdetLabel);
        JTextField stokAdetField = new JTextField(10);
        stokSolUstPanel.add(stokAdetField);
        JLabel stokTarihLabel = new JLabel("Tarih",JLabel.RIGHT);
        stokSolUstPanel.add(stokTarihLabel);
        JDateChooser stokTarih = new JDateChooser();
        stokSolUstPanel.add(stokTarih);

        JButton stokGuncelleButton = new JButton("Güncelle");
        stokSolUstPanel.add(stokGuncelleButton);
        JButton stokEkleButton = new JButton("Ekle");
        stokSolUstPanel.add(stokEkleButton);

        //Satis İşlemleri
        JPanel satisSagPanel = new JPanel(new BorderLayout());
        JPanel satisSagUstPanel = new JPanel(new GridLayout(4,2));
        JPanel satisSagAltPanel = new JPanel();
        satisSagPanel.setBorder(BorderFactory.createTitledBorder("Stoklar"));
        String[] satisKolonlar = {"Id","Personel Ad","Müsteri Ad","Ürün Ad","Adet","Tarih"};
        DefaultTableModel satismodel = new DefaultTableModel(satisKolonlar,0);
        JTable satisTable = new JTable(satismodel);
        JScrollPane satisTablePane = new JScrollPane(table);

        JLabel satisUrunAdiLabel = new JLabel("Ürün Adı",JLabel.RIGHT);
        satisSagUstPanel.add(satisUrunAdiLabel);
        JComboBox satisUrunAdiBox = new JComboBox();
        satisSagUstPanel.add(satisUrunAdiBox);
        JLabel satisAdetLabel = new JLabel("Adet",JLabel.RIGHT);
        satisSagUstPanel.add(satisAdetLabel);
        JTextField satisAdetField = new JTextField(10);
        satisSagUstPanel.add(satisAdetField);
        JLabel satisTarihLabel = new JLabel("Tarih",JLabel.RIGHT);
        satisSagUstPanel.add(satisTarihLabel);
        JDateChooser satisTarih = new JDateChooser();
        satisSagUstPanel.add(satisTarih);

        JButton satisGuncelleButton = new JButton("Güncelle");
        satisSagUstPanel.add(satisGuncelleButton);
        JButton satisEkleButton = new JButton("Ekle");
        satisSagUstPanel.add(satisEkleButton);

        stokPanel.add(stokSolPanel,BorderLayout.WEST);
        stokPanel.add(stokTablePane,BorderLayout.CENTER);

        satisPanel.add(satisSagPanel,BorderLayout.EAST);
        satisPanel.add(satisTablePane,BorderLayout.CENTER);

        satisSagPanel.add(satisSagUstPanel,BorderLayout.NORTH);
        satisSagPanel.add(satisSagAltPanel,BorderLayout.SOUTH);




        stokSolPanel.add(stokSolUstPanel,BorderLayout.NORTH);
        stokSolPanel.add(stokSolAltPanel,BorderLayout.SOUTH);

        pane.addTab("Stoklar",icon , stokPanel ,"HiçBirşey");
        pane.addTab("Satislar",icon , satisPanel ,"HiçBirşey");
        return pane;
    }
}
