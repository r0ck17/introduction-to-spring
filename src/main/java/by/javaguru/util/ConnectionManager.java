package by.javaguru.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static Connection getConnection(String url, String username, String password, String schema) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.setSchema(schema);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
