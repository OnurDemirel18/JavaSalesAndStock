package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.KategoriContract;
import tr.com.onurdemirel.types.SehirContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SehirDal extends ObjectHelper implements DalI<SehirContract>{

    @Override
    public void Insert(SehirContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO sehir (sehirAdi) VALUES('" + entity.getSehirAdi() + "')");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<SehirContract> GetAll() {
        List<SehirContract> datacontract = new ArrayList<SehirContract>();

        Connection connection = getConnection();
        SehirContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sehir ");
            while (resultSet.next()){
                contract = new SehirContract();
                contract.setSehirId(resultSet.getInt("Id"));
                contract.setSehirAdi(resultSet.getString("sehirAdi"));
                datacontract.add(contract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return datacontract;

    }

    @Override
    public SehirContract Delete(SehirContract entity) {
        return null;
    }

    @Override
    public void Update(SehirContract entity) {

    }

    @Override
    public List<SehirContract> GetById(int id) {
        return null;
    }
}
