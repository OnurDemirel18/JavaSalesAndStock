package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.HesaplarContract;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class HesaplarDal extends ObjectHelper implements DalI<HesaplarContract> {
    @Override
    public void Insert(HesaplarContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO accounts ( yetkiId, personelId, sifre)"
                    + " VALUES(" + entity.getYetkiId()
                    + ", "
                    + entity.getPersonelId()
                    + ", '"
                    + entity.getSifre()
                    + "')");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<HesaplarContract> GetAll() {
        return null;
    }

    @Override
    public HesaplarContract Delete(HesaplarContract entity) {
        return null;
    }

    @Override
    public HesaplarContract Update(HesaplarContract entity) {
        return null;
    }

    @Override
    public List<HesaplarContract> GetById(int id) {
        return null;
    }
}
