package ru.coffee.repository.impl;

import ru.coffee.config.DBConnection;
import ru.coffee.domain.model.Person;
import ru.coffee.repository.Repository;

import java.sql.*;

public class PersonRepositoryImpl implements Repository<Person> {

    private Connection connection;


    public PersonRepositoryImpl(DBConnection connection) {
        this.connection = connection.getConnection();
    }

    @Override
    public Person addPerson(Person person) {
        Integer[] personScore = {person.getPhysics(), person.getMathematics(), person.getRus(),
                person.getLiterature(), person.getGeometry(), person.getInformatics()};


        String insertIntoClass = "INSERT INTO class (class_number) " +
                                 "VALUES (?);";

        String insertIntoPersonProgress = "INSERT INTO person_progress (score) " +
                                          "VALUES (?);";

        String findIdClass = "SELECT class_id FROM class WHERE class_number = ?";

        String insertIntoPerson = "INSERT INTO person (name, last_name, age, class_id) " +
                                  "VALUES (?, ?, ?, ?) ";
        try {
            int classId = 0;
            PreparedStatement statement;

            Array arrayWithScore = connection.createArrayOf("int", personScore);
            statement = connection.prepareStatement(insertIntoPersonProgress);
            statement.setArray(1, arrayWithScore);
            statement.executeUpdate();

            statement = connection.prepareStatement(findIdClass);
            statement.setInt(1, person.getClassroom());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                classId = resultSet.findColumn("class_id");
                System.out.println("CLASS ID" + classId);
            } else {
                System.out.println("WE ARE IN A BLOCK ELSE");
                statement = connection.prepareStatement(insertIntoClass, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, person.getClassroom());
                statement.executeUpdate();
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    classId = generatedKeys.findColumn("class_id");
                }
            }

            statement = connection.prepareStatement(insertIntoPerson);
            statement.setString(1, person.getName());
            statement.setString(2, person.getLastName());
            statement.setInt(3, person.getAge());
            statement.setInt(4, classId);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }
}
