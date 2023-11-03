package ru.coffee.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

    private Properties properties;
    public DBConnection(Properties properties) {
        this.properties = properties;
//        createConnectionAndTable();
    }

    private void createConnectionAndTable() {
        Connection connection = getConnection();
        try {
            Statement initTable = connection.createStatement();
            String sqlScript = new String(Files.readAllBytes(Paths.get("src/main/resources/initdb.sql")));
            initTable.executeUpdate(sqlScript);

        } catch (SQLException | IOException e) {
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
