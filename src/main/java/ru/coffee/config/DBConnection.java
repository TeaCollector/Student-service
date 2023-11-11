package ru.coffee.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

    public DBConnection() {
        createConnectionAndTable();
    }

    public Connection getConnection() {
        try {
            Properties properties = new Properties();
            try (InputStreamReader in = new InputStreamReader(new FileInputStream("src/main/resources/db.properties"))) {
                properties.load(in);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String url = properties.getProperty("jdbc.postgres.url");
            String username = properties.getProperty("jdbc.postgres.username");
            String password = properties.getProperty("jdbc.postgres.password");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createConnectionAndTable() {
        Connection connection = getConnection();
        try {
            Statement initTable = connection.createStatement();
            String sqlScript = new String(Files.readAllBytes(Paths.get("src/main/resources/initdb.sql")));
            initTable.executeUpdate(sqlScript);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
