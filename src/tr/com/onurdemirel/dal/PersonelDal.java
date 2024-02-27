package tr.com.onurdemirel.dal;

import tr.com.onurdemirel.core.ObjectHelper;
import tr.com.onurdemirel.interfaces.DalI;
import tr.com.onurdemirel.types.KategoriContract;
import tr.com.onurdemirel.types.PersonelContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonelDal extends ObjectHelper implements DalI<PersonelContract> {
    @Override
    public void Insert(PersonelContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO personel (personelAdSoyad, email) "
                    + "VALUES('"
                    + entity.getPersonelAdSoyad()
                    + "', '"
                    + entity.getEmail() + "')");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PersonelContract> GetAll() {
        List<PersonelContract> datacontract = new ArrayList<PersonelContract>();

        Connection connection = getConnection();
        PersonelContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM personel");
            while (resultSet.next()){
                contract = new PersonelContract();
                contract.setPersonelId(resultSet.getInt("id"));
                contract.setPersonelAdSoyad(resultSet.getString("personelAdSoyad"));
                contract.setEmail(resultSet.getString("email"));
                datacontract.add(contract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return datacontract;

    }

    @Override
    public PersonelContract Delete(PersonelContract entity) {
        return null;
    }

    @Override
    public void Update(PersonelContract entity) {

    }

    @Override
    public List<PersonelContract> GetById(int id) {
        return null;
    }
}
