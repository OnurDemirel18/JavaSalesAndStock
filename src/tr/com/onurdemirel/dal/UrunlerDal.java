package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.KategoriContract;
import tr.com.onurdemirel.types.UrunlerContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Bu sınıfın amacı veritabanı işlemlerini yapmaktır. UrunlerContract sınıfı ile çalışır.
public class UrunlerDal extends ObjectHelper implements DalI<UrunlerContract> {

    // Urunler tablosuna yeni bir kayıt ekler.
    @Override
    public void Insert(UrunlerContract entity) {
        // Veritabanı bağlantısını alır.
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO urunler (urunAdi, urunKategoriId, urunTarih, urunFiyat) "
                    + "VALUES('"
                    + entity.getUrunAdi()
                    + "', "
                    + entity.getUrunKategoriId()
                    + ", '"
                    + entity.getUrunTarih()
                    + "',"
                    + entity.getUrunFiyat()
                    + ")");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UrunlerContract> GetAll() {
        List<UrunlerContract> datacontract = new ArrayList<UrunlerContract>();
        UrunlerContract contract;
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM urunler");
            while (resultSet.next()){
                contract = new UrunlerContract();
                contract.setUrunId(resultSet.getInt("urunId"));
                contract.setUrunAdi(resultSet.getString("urunAdi"));
                contract.setUrunKategoriId(resultSet.getInt("urunKategoriId"));
                contract.setUrunTarih(resultSet.getDate("urunTarih"));
                datacontract.add(contract);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return datacontract;


    }

    @Override
    public UrunlerContract Delete(UrunlerContract entity) {
        return null;
    }

    @Override
    public void Update(UrunlerContract entity) {

    }

    @Override
    public List<UrunlerContract> GetById(int id) {
        return null;
    }
}
