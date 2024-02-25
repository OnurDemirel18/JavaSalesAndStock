package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.complex.types.StokContractComplex;
import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.KategoriContract;
import tr.com.onurdemirel.types.StokContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StokDal extends ObjectHelper implements DalI<StokContract> {

    @Override
    public void Insert(StokContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO stok (personelId, urunId,tarih,adet) VALUES("+entity.getPersonelId()+","+entity.getUrunId()+",'"+entity.getTarih()+"',"+entity.getAdet()+" )");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<StokContractComplex> GetAllStok(){
        List<StokContractComplex> datacontract = new ArrayList<StokContractComplex>();
        StokContractComplex contract;
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT stokId,personel.personelAdSoyad, urunler.urunAdi, adet, stok.tarih FROM stok LEFT JOIN urunler on stok.urunId = urunler.urunId LEFT JOIN personel on stok.personelId = personel.Id");
            while (resultSet.next()){
                contract = new StokContractComplex();
                contract.setId(resultSet.getInt("stokId"));
                contract.setPersonelAdi(resultSet.getString("personel.personelAdSoyad"));
                contract.setUrunAdi(resultSet.getString("urunler.urunAdi"));
                contract.setAdet(resultSet.getInt("adet"));
                contract.setTarih(resultSet.getDate("stok.tarih"));

                datacontract.add(contract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return datacontract;
    }
    @Override
    public List<StokContract> GetAll() {
        return null;
    }

    @Override
    public StokContract Delete(StokContract entity) {
        return null;
    }

    @Override
    public StokContract Update(StokContract entity) {
        return null;
    }

    @Override
    public List<StokContract> GetById(int id) {
        return null;
    }
}
