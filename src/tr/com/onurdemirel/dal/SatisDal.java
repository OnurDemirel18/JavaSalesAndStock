package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.SatisContract;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SatisDal extends ObjectHelper implements DalI<SatisContract> {
    @Override
    public void Insert(SatisContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO satis (kategoriAdi, parentId) VALUES()");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<SatisContract> GetAll() {
        return null;
    }

    @Override
    public SatisContract Delete(SatisContract entity) {
        return null;
    }

    @Override
    public SatisContract Update(SatisContract entity) {
        return null;
    }

    @Override
    public List<SatisContract> GetById(int id) {
        return null;
    }
}
