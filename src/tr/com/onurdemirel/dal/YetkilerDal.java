package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.PersonelContract;
import tr.com.onurdemirel.types.Yetkiler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class YetkilerDal extends ObjectHelper implements DalI<Yetkiler> {
    @Override
    public void Insert(Yetkiler entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO yetkiler (yetkiAdi) VALUES('" + entity.getYetkiAdi() + "')");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Yetkiler> GetAll() {
        List<Yetkiler> datacontract = new ArrayList<Yetkiler>();

        Connection connection = getConnection();
        Yetkiler contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM yetkiler");
            while (resultSet.next()){
                contract = new Yetkiler();
                contract.setYetkiId(resultSet.getInt("yetkiId"));
                contract.setYetkiAdi(resultSet.getString("yetkiAdi"));

                datacontract.add(contract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return datacontract;
    }

    @Override
    public Yetkiler Delete(Yetkiler entity) {
        return null;
    }

    @Override
    public void Update(Yetkiler entity) {

    }

    @Override
    public List<Yetkiler> GetById(int id) {
        return null;
    }
}
