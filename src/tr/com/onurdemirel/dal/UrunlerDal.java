package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.UrunlerContract;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
        return null;
    }

    @Override
    public UrunlerContract Delete(UrunlerContract entity) {
        return null;
    }

    @Override
    public UrunlerContract Update(UrunlerContract entity) {
        return null;
    }

    @Override
    public List<UrunlerContract> GetById(int id) {
        return null;
    }
}
