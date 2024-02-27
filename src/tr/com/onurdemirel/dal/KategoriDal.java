package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.KategoriContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KategoriDal extends ObjectHelper implements DalI<KategoriContract> {


    @Override
    public void Insert(KategoriContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO kategori (kategoriAdi, parentId) VALUES('" + entity.getKategoriAdi() + "', " + entity.getParentId() + ")");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<KategoriContract> GetAllParentId() {
        List<KategoriContract> datacontract = new ArrayList<KategoriContract>();

        Connection connection = getConnection();
        KategoriContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM kategori WHERE parentId = 0");
            while (resultSet.next()){
                contract = new KategoriContract();
                contract.setKategoriId(resultSet.getInt("kategoriId"));
                contract.setKategoriAdi(resultSet.getString("kategoriAdi"));
                contract.setParentId(resultSet.getInt("parentId"));
                datacontract.add(contract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return datacontract;
    }

    @Override
    public List<KategoriContract> GetAll() {
        List<KategoriContract> datacontract = new ArrayList<KategoriContract>();
        KategoriContract contract;
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM kategori");
            while (resultSet.next()){
                contract = new KategoriContract();
                contract.setKategoriId(resultSet.getInt("kategoriId"));
                contract.setKategoriAdi(resultSet.getString("kategoriAdi"));
                contract.setParentId(resultSet.getInt("parentId"));
                datacontract.add(contract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return datacontract;
    }

    @Override
    public KategoriContract Delete(KategoriContract entity) {
        return null;
    }

    @Override
    public void Update(KategoriContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE kategori SET kategoriAdi = '" + entity.getKategoriAdi() + "', parentId = " + entity.getParentId() + " WHERE kategoriId = " + entity.getKategoriId()+ "");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<KategoriContract> GetById(int id) {
        return null;
    }

    public List<KategoriContract> GetSearchKategori(String kategoriAdi) {
        List<KategoriContract> datacontract = new ArrayList<KategoriContract>();

        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM kategori WHERE kategoriAdi LIKE '%" + kategoriAdi + "%'");
            while (resultSet.next()){
                KategoriContract contract = new KategoriContract();
                contract.setKategoriAdi(resultSet.getString("kategoriAdi"));
                contract.setParentId(resultSet.getInt("parentId"));
                datacontract.add(contract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return datacontract;
    }


}
