package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.MusteriContract;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MusteriDal extends ObjectHelper implements DalI<MusteriContract> {
    @Override
    public void Insert(MusteriContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO musteri (musteriAdiSoyadi, musteriTelefon,musteriAdres,sehirId) VALUES('" + entity.getMusteriAdiSoyadi() + "', '" + entity.getMusteriTelefon() + "', '" + entity.getMusteriAdres() + "', '" + entity.getSehirId() + "')");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MusteriContract> GetAll() {
        return null;
    }

    @Override
    public MusteriContract Delete(MusteriContract entity) {
        return null;
    }

    @Override
    public MusteriContract Update(MusteriContract entity) {
        return null;
    }

    @Override
    public List<MusteriContract> GetById(int id) {
        return null;
    }
}
