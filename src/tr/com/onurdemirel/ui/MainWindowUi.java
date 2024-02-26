package tr.com.onurdemirel.ui;

import com.toedter.calendar.JDateChooser;
import tr.com.onurdemirel.complex.types.SatisContractComplex;
import tr.com.onurdemirel.complex.types.StokContractComplex;
import tr.com.onurdemirel.complex.types.StokContractToplamComplex;
import tr.com.onurdemirel.dal.MusteriDal;
import tr.com.onurdemirel.dal.SatisDal;
import tr.com.onurdemirel.dal.StokDal;
import tr.com.onurdemirel.dal.UrunlerDal;
import tr.com.onurdemirel.interfaces.UiI;
import tr.com.onurdemirel.types.*;
import tr.com.onurdemirel.utilities.MenulerCom;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

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
        JPanel stokSolUstPanel = new JPanel(new GridLayout(5,2));
        JPanel stokSolAltPanel = new JPanel();
        stokSolPanel.setBorder(BorderFactory.createTitledBorder("Stoklar"));
        String[] stokKolonlar = {"Id","Personel Ad","Ürün Ad","Adet","Tarih"};
        DefaultTableModel stokModel = new DefaultTableModel(stokKolonlar,0);
        JTable stokTable = new JTable(stokModel);
        JScrollPane stokTablePane = new JScrollPane(stokTable);

        for (StokContractComplex stokContractComplex: new StokDal().GetAllStok()){
            stokModel.addRow(new Object[]{stokContractComplex.getId(),stokContractComplex.getPersonelAdi(),stokContractComplex.getUrunAdi(),stokContractComplex.getAdet(),stokContractComplex.getTarih()});
        }
        JLabel stokUrunAdiLabel = new JLabel("Ürün Adı",JLabel.RIGHT);
        stokSolUstPanel.add(stokUrunAdiLabel);
        JComboBox stokUrunAdiBox = new JComboBox(new UrunlerDal().GetAll().toArray());
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
        JButton stokToplamButton = new JButton("Stok Toplam");
        stokSolUstPanel.add(stokToplamButton);
        stokGuncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int satir = stokModel.getRowCount();
                for (int i = 0; i < satir; i++) {
                    stokModel.removeRow(0);
                }
                for (StokContractComplex stokContractComplex: new StokDal().GetAllStok()){
                    stokModel.addRow(new Object[]{stokContractComplex.getId(),stokContractComplex.getPersonelAdi(),stokContractComplex.getUrunAdi(),stokContractComplex.getAdet(),stokContractComplex.getTarih()});
                }
            }
        });

        stokEkleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StokContract contract = new StokContract();
                UrunlerContract uContract = (UrunlerContract) stokUrunAdiBox.getSelectedItem();
                PersonelContract pContract = (PersonelContract) LoginCom.emailBox.getSelectedItem();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String date = format.format(stokTarih.getDate());
                contract.setPersonelId(pContract.getPersonelId());
                contract.setUrunId(uContract.getUrunId());
                contract.setTarih(java.sql.Date.valueOf(date));
                contract.setAdet(Integer.parseInt(stokAdetField.getText()));


                new StokDal().Insert(contract);

                JOptionPane.showMessageDialog(null, uContract.getUrunAdi() + " Ürünü Eklendi");

                int satir = stokModel.getRowCount();
                for (int i = 0; i < satir; i++) {
                    stokModel.removeRow(0);
                }
                for (StokContractComplex stokContractComplex: new StokDal().GetAllStok()){
                    stokModel.addRow(new Object[]{stokContractComplex.getId(),stokContractComplex.getPersonelAdi(),stokContractComplex.getUrunAdi(),stokContractComplex.getAdet(),stokContractComplex.getTarih()});
                }
            }
        });

        stokToplamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int satir = stokModel.getRowCount();
                for (int i = 0; i < satir; i++) {
                    stokModel.removeRow(0);
                }
                for (StokContractToplamComplex stokContractToplamComplex: new StokDal().GetToplamStok()){
                    stokModel.addRow(new Object[]{stokContractToplamComplex.getId(),stokContractToplamComplex.getPersonelAdi(),stokContractToplamComplex.getUrunAdi(),stokContractToplamComplex.getToplam(),stokContractToplamComplex.getTarih()});
                }



            }
        });

        //Satis İşlemleri
        JPanel satisSagPanel = new JPanel(new BorderLayout());
        JPanel satisSagUstPanel = new JPanel(new GridLayout(6,2));
        JPanel satisSagAltPanel = new JPanel();
        satisSagPanel.setBorder(BorderFactory.createTitledBorder("Satışlar"));
        String[] satisKolonlar = {"Id","Personel Ad","Müsteri Ad","Ürün Ad","Adet","Tarih"};
        DefaultTableModel satismodel = new DefaultTableModel(satisKolonlar,0);
        JTable satisTable = new JTable(satismodel);
        JScrollPane satisTablePane = new JScrollPane(satisTable);
        JLabel musteriLabel = new JLabel("Müşteri Adı",JLabel.RIGHT);
        satisSagUstPanel.add(musteriLabel);
        JComboBox musteriBox = new JComboBox(new MusteriDal().GetAll().toArray());
        satisSagUstPanel.add(musteriBox);

        JLabel satisUrunAdiLabel = new JLabel("Ürün Adı",JLabel.RIGHT);
        satisSagUstPanel.add(satisUrunAdiLabel);
        JComboBox satisUrunAdiBox = new JComboBox(new UrunlerDal().GetAll().toArray());
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
        JButton satisEkleButton = new JButton("Sat");
        satisSagUstPanel.add(satisEkleButton);


        for (SatisContractComplex satisContractComplex: new SatisDal().GetAllSatis()){
            satismodel.addRow(new Object[]{satisContractComplex.getSatisId(),satisContractComplex.getPersonelAdi(),satisContractComplex.getMusteriAdi(),satisContractComplex.getUrunAdi(),satisContractComplex.getAdet(),satisContractComplex.getTarih()});
        }

        satisGuncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int satir = satismodel.getRowCount();
                for (int i = 0; i < satir; i++) {
                    satismodel.removeRow(0);
                }
                for (SatisContractComplex satisContractComplex: new SatisDal().GetAllSatis()){
                    satismodel.addRow(new Object[]{satisContractComplex.getSatisId(),satisContractComplex.getPersonelAdi(),satisContractComplex.getMusteriAdi(),satisContractComplex.getUrunAdi(),satisContractComplex.getAdet(),satisContractComplex.getTarih()});
                }
            }
        });
        satisEkleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonelContract pContract = (PersonelContract) LoginCom.emailBox.getSelectedItem();
                UrunlerContract uContract = (UrunlerContract) satisUrunAdiBox.getSelectedItem();
                MusteriContract mContract = (MusteriContract) musteriBox.getSelectedItem();
                SatisContract contract = new SatisContract();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String date = format.format(satisTarih.getDate());

                contract.setPersonelId(pContract.getPersonelId());
                contract.setUrunId(uContract.getUrunId());
                contract.setMusteriId(mContract.getMusteriId());
                contract.setTarih(java.sql.Date.valueOf(date));
                contract.setAdet(Integer.parseInt(satisAdetField.getText()));


                new SatisDal().Insert(contract);
                StokContract stokContract = new StokContract();
                stokContract.setAdet(stokContract.getAdet() - Integer.parseInt(satisAdetField.getText()));
                stokContract.setPersonelId(pContract.getPersonelId());
                stokContract.setUrunId(uContract.getUrunId());
                stokContract.setTarih(java.sql.Date.valueOf(date));
                stokContract.setAdet(-Integer.parseInt(satisAdetField.getText()));
                new StokDal().Insert(stokContract);

                JOptionPane.showMessageDialog(null, uContract.getUrunAdi() + " Ürünü Satıldı");

                int satir = satismodel.getRowCount();
                for (int i = 0; i < satir; i++) {
                    satismodel.removeRow(0);
                }
                for (SatisContractComplex satisContractComplex: new SatisDal().GetAllSatis()){
                    satismodel.addRow(new Object[]{satisContractComplex.getSatisId(),satisContractComplex.getPersonelAdi(),satisContractComplex.getMusteriAdi(),satisContractComplex.getUrunAdi(),satisContractComplex.getAdet(),satisContractComplex.getTarih()});
                }

            }
        });


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
