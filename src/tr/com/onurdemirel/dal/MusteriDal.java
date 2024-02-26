package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.KategoriContract;
import tr.com.onurdemirel.types.MusteriContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        List<MusteriContract> datacontract = new ArrayList<MusteriContract>();
        MusteriContract contract;
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM musteri");
            while (resultSet.next()){
                contract = new MusteriContract();
                contract.setMusteriId(resultSet.getInt("musteriId"));
                contract.setMusteriAdiSoyadi(resultSet.getString("musteriAdiSoyadi"));
                contract.setMusteriAdres(resultSet.getString("musteriAdres"));
                contract.setSehirId(resultSet.getInt("sehirId"));
                contract.setMusteriTelefon(resultSet.getString("musteriTelefon"));
                datacontract.add(contract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return datacontract;

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
