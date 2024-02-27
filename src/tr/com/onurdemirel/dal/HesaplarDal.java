package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.HesaplarContract;
import tr.com.onurdemirel.types.PersonelContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    public HesaplarContract GetPersonelIdVeSifre(int personelId, String sifre) {
        HesaplarContract contract = new HesaplarContract();
        List<HesaplarContract> datacontract = new ArrayList<HesaplarContract>();

        Connection connection = getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts WHERE personelId ="+personelId+" AND sifre = '"+sifre.trim()+"'");
            while (resultSet.next()){
                contract.setHesapId(resultSet.getInt("hesapId"));
                contract.setPersonelId(resultSet.getInt("personelId"));
                contract.setSifre(resultSet.getString("sifre"));
                contract.setYetkiId(resultSet.getInt("yetkiId"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contract;

    }
    public HesaplarContract GetYetkiId(int personelId) {
        HesaplarContract contract = new HesaplarContract();
        List<HesaplarContract> datacontract = new ArrayList<HesaplarContract>();

        Connection connection = getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts WHERE personelId ="+personelId+"");
            while (resultSet.next()){
                contract.setHesapId(resultSet.getInt("hesapId"));
                contract.setPersonelId(resultSet.getInt("personelId"));
                contract.setYetkiId(resultSet.getInt("yetkiId"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contract;

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
    public void Update(HesaplarContract entity) {

    }

    @Override
    public List<HesaplarContract> GetById(int id) {
        return null;
    }
}
