package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.complex.types.SatisContractComplex;
import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.SatisContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SatisDal extends ObjectHelper implements DalI<SatisContract> {
    @Override
    public void Insert(SatisContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO satis (musteriId, personelId, urunId, adet, tarih) VALUES("+entity.getMusteriId()+" , "+entity.getPersonelId()+" , "+entity.getUrunId()+" , "+entity.getAdet()+" , '"+entity.getTarih()+"')");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<SatisContractComplex> GetAllSatis() {
        List<SatisContractComplex> dataContract = new ArrayList<SatisContractComplex>();
        Connection connection = getConnection();
        SatisContractComplex contract;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT satis.satisId, personel.personelAdSoyad, musteri.musteriAdiSoyadi, urunler.urunAdi, adet, satis.tarih FROM satis LEFT JOIN musteri on satis.musteriId = musteri.musteriId LEFT JOIN urunler on satis.urunId = urunler.urunId LEFT JOIN personel on satis.personelId = personel.Id ORDER BY satis.satisId DESC");
            while (resultSet.next()) {
                contract = new SatisContractComplex();
                contract.setSatisId(resultSet.getInt("satis.satisId"));
                contract.setPersonelAdi(resultSet.getString("personel.personelAdSoyad"));
                contract.setMusteriAdi(resultSet.getString("musteri.musteriAdiSoyadi"));
                contract.setUrunAdi(resultSet.getString("urunler.urunAdi"));
                contract.setAdet(resultSet.getInt("adet"));
                contract.setTarih(resultSet.getDate("satis.tarih"));

                dataContract.add(contract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dataContract;
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
    public void Update(SatisContract entity) {

    }

    @Override
    public List<SatisContract> GetById(int id) {
        return null;
    }
}
