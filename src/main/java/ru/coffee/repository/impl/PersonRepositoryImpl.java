package ru.coffee.repository.impl;

import ru.coffee.config.DBConnection;
import ru.coffee.domain.dto.PersonDto;
import ru.coffee.mapper.PersonMapper;
import ru.coffee.repository.Repository;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImpl implements Repository<PersonDto> {

    private DBConnection dbConnection;
    private Connection connection;
    private PersonMapper mapper;


    public PersonRepositoryImpl(DBConnection dbConnection, PersonMapper mapper) {
        this.dbConnection = dbConnection;
        this.mapper = mapper;
    }

    @Override
    public PersonDto addPerson(PersonDto person) {

        String insertIntoPersonProgress = "INSERT INTO person_progress (physic, mathematics, rus, literature, geometry,informatics) " +
                                          "VALUES (?, ?, ?, ?, ?, ?);";

        String insertIntoPerson = "INSERT INTO person (name, last_name, age, class_id) " +
                                  "VALUES (?, ?, ?, ?) ";
        try {
            connection = dbConnection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement;
            statement = connection.prepareStatement(insertIntoPersonProgress);
            statement.setInt(1, person.getPhysics());
            statement.setInt(2, person.getMathematics());
            statement.setInt(3, person.getRus());
            statement.setInt(4, person.getLiterature());
            statement.setInt(5, person.getGeometry());
            statement.setInt(6, person.getInformatics());
            statement.executeUpdate();

            statement = connection.prepareStatement(insertIntoPerson);
            statement.setString(1, person.getName());
            statement.setString(2, person.getLastName());
            statement.setInt(3, person.getAge());
            statement.setInt(4, person.getClassroom());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return person;
    }

    @Override
    public List<BigDecimal> averageScore() {
        List<BigDecimal> personDtoList = new ArrayList<>();
        String average = "SELECT " +
                         "(SELECT sum(pp.geometry + pp.informatics + pp.literature + pp.physic + pp.rus + pp.mathematics) / 6 / count(p.class_id) " +
                         "FROM person p JOIN person_progress pp ON p.pp_id = pp.pp_id " +
                         "WHERE p.class_id = 10) " +
                         "AS score10," +

                         "(SELECT sum(pp.geometry + pp.informatics + pp.literature + pp.physic + pp.rus + pp.mathematics) / 6 / count(p.class_id) " +
                         "FROM person p JOIN person_progress pp ON p.pp_id = pp.pp_id " +
                         "WHERE p.class_id = 11) " +
                         "AS score11 " +

                         "FROM person p " +
                         "JOIN person_progress pp " +
                         "ON p.pp_id = pp.pp_id ";

        try {
            connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(average);
            if (resultSet.next()) {
                personDtoList.add(resultSet.getBigDecimal("score10"));
                personDtoList.add(resultSet.getBigDecimal("score11"));
            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return personDtoList;
    }

    @Override
    public List<PersonDto> excellentPerson() {
        List<PersonDto> personDtoList = new ArrayList<>();
        String sql = "SELECT p.name, p.last_name " +
                     "FROM person p " +
                     "JOIN person_progress pp ON p.person_id = pp.pp_id " +
                     "WHERE p.age > 14 " +
                     "AND pp.rus = 5 " +
                     "AND pp.physic = 5 " +
                     "AND pp.mathematics = 5 " +
                     "AND pp.literature = 5 " +
                     "AND pp.geometry = 5 " +
                     "AND pp.informatics = 5";
        Statement statement;
        try {
            connection = dbConnection.getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                PersonDto personDto = PersonDto.builder()
                        .name(rs.getString("name"))
                        .lastName(rs.getString("last_name"))
                        .build();
                personDtoList.add(personDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return personDtoList;
    }

    public List<PersonDto> personsAverage(String lastName) {
        List<PersonDto> personList = new ArrayList<>();
        String sql = "SELECT p.name, p.last_name, p.class_id, " +
                     "((pp.rus + pp.mathematics + pp.informatics + pp.physic + pp.geometry + pp.geometry) / 6) " +
                     "AS average_score " +
                     "FROM person p " +
                     "JOIN person_progress pp " +
                     "ON p.pp_id = pp.pp_id " +
                     "JOIN class c " +
                     "ON c.class_id = p.class_id " +
                     "WHERE p.last_name = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, lastName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                PersonDto personDto = PersonDto.builder()
                        .name(rs.getString("name"))
                        .lastName(rs.getString("last_name"))
                        .average(rs.getDouble("average_score"))
                        .classroom(rs.getInt("class_id"))
                        .build();
                personList.add(personDto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return personList;
    }
}