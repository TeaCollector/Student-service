package ru.coffee.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private final String url;
    private final String username;
    private final String password;


    public DBConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        createTable();
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createTable() {
        Connection connection = getConnection();
        try {
            String initTableLesson = "CREATE TABLE IF NOT EXISTS lesson (" +
                                "lesson_id SERIAL PRIMARY KEY," +
                                "lesson_name VARCHAR (20) NOT NULL);";

            String initTablePersonProgress = "CREATE TABLE IF NOT EXISTS person_progress (" +
                                             "pp_id SERIAL PRIMARY KEY," +
                                             "score INT[]);";

            String initTableClass = "CREATE TABLE IF NOT EXISTS class (" +
                                    "class_id SERIAL PRIMARY KEY," +
                                    "class_number INT);";

            String initTablePerson = "CREATE TABLE IF NOT EXISTS person (" +
                                  "person_id SERIAL PRIMARY KEY," +
                                  "name VARCHAR (20) NOT NULL ," +
                                  "last_name VARCHAR(25) NOT NULL," +
                                  "age INT NOT NULL," +
                                  "class_id INT," +
                                  "pp_id INT," +
                                  "lesson_id INT," +
                                  "FOREIGN KEY (class_id) REFERENCES class (class_id)," +
                                  "FOREIGN KEY  (pp_id) REFERENCES person_progress(pp_id)," +
                                  "FOREIGN KEY (lesson_id) REFERENCES lesson(lesson_id));";
            Statement initTable = connection.createStatement();
            initTable.executeUpdate(initTableLesson);
            initTable.executeUpdate(initTableClass);
            initTable.executeUpdate(initTablePersonProgress);
            initTable.executeUpdate(initTablePerson);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
