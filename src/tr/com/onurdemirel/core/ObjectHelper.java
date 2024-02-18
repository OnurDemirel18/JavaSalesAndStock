package tr.com.onurdemirel.core;

import tr.com.onurdemirel.interfaces.CoreI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ObjectHelper extends CoreFields implements CoreI {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Connection getConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(getUrl(), getUserName(), getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
