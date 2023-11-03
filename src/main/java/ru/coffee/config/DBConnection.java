package ru.coffee.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

    private Properties properties;
    private String sqlScript;
    public DBConnection(Properties properties, String sqlScript) {
        this.properties = properties;
        this.sqlScript = sqlScript;
        createConnectionAndTable();
    }

    private void createConnectionAndTable() {
        Connection connection = getConnection();
        try {
            Statement initTable = connection.createStatement();
            initTable.executeUpdate(sqlScript);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
            String url = properties.getProperty("jdbc.postgres.url");
            String username = properties.getProperty("jdbc.postgres.username");
            String password = properties.getProperty("jdbc.postgres.password");
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
