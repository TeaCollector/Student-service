package ru.coffee.repository.impl;

import ru.coffee.domain.dto.PersonDtoWithServlet;
import ru.coffee.domain.model.Person;
import ru.coffee.repository.ServletRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonServletRepositoryImpl implements ServletRepository<Person, PersonDtoWithServlet> {

    private Connection connection;

    public PersonServletRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public PersonDtoWithServlet changePersonsScore(PersonDtoWithServlet personDto) {
        String sql = String.format("UPDATE person_progress " +
                                   "SET %s = ? " +
                                   "WHERE pp_id = (" +
                                   "SELECT p.pp_id " +
                                   "FROM person p " +
                                   "JOIN class c " +
                                   "ON p.class_id = c.class_id " +
                                   "WHERE p.name = ? " +
                                   "AND p.last_name = ? " +
                                   "AND p.class_id = ?)", personDto.getLesson());
        System.out.println("SQL: " + sql);
        int rowUpdated;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2, personDto.getName());
            statement.setString(3, personDto.getLastName());
            statement.setInt(4, personDto.getClassroom());
            statement.setInt(1, personDto.getScore());
            rowUpdated = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        personDto.setScore(rowUpdated);
        return personDto;
    }

    @Override
    public List<PersonDtoWithServlet> findAverageScoreConcreteClass(int classroom) {
        List<PersonDtoWithServlet> personDtoList = new ArrayList<>();
        String sql = "SELECT p.name, p.last_name, p.class_id, " +
                     "(pp.rus + pp.literature + pp.mathematics + " +
                     " pp.geometry + pp.informatics + pp.physic) / 6 AS average " +
                     "FROM person p " +
                     "JOIN class c on p.class_id = c.class_id " +
                     "JOIN person_progress pp on p.pp_id = pp.pp_id " +
                     "WHERE p.class_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, classroom);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PersonDtoWithServlet personDto = PersonDtoWithServlet.builder()
                        .name(resultSet.getString("name"))
                        .lastName(resultSet.getString("last_name"))
                        .classroom(resultSet.getInt("class_id"))
                        .average(resultSet.getInt("average"))
                        .build();
                personDtoList.add(personDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personDtoList;
    }
}
