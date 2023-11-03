package ru.coffee.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.coffee.config.DBConnection;
import ru.coffee.domain.dto.PersonDto;
import ru.coffee.mapper.PersonMapper;
import ru.coffee.repository.Repository;
import ru.coffee.repository.impl.PersonRepositoryImpl;
import ru.coffee.service.Service;
import ru.coffee.service.impl.PersonServiceImpl;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

//Изменение оценки конкретного ученика (по ФИО и классу) и конкретного предмета

@WebServlet("/persons")
public class UpdateScoreServlet extends HttpServlet {

    private Service personService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("db.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ServletContext sc = config.getServletContext();
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        connection = new DBConnection(properties).getConnection();
        PersonMapper mapper = PersonMapper.INSTANCE;
        Repository repository = new PersonRepositoryImpl(connection, mapper);
        personService = new PersonServiceImpl(repository);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader reader = req.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        String requestBodyString = requestBody.toString();
        PersonDto personDto = mapper.readValue(requestBodyString, PersonDto.class);
        System.out.println(personDto);
        personService.changePersonsScore(personDto);

        resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        resp.setContentType("application/json");
        out.write(personDto.toString());
        out.flush();
    }


//    Получения средних оценок каждого ученика в указанном классе

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Integer personClass = Integer.valueOf(req.getParameter("class"));
        List<PersonDto> personDtoList = personService.findAverageScoreConcreteClass(personClass);
        for (PersonDto personDto : personDtoList) {
            out.println(personDto.getName() + " " + personDto.getLastName() + " class: " +
                        personDto.getClassroom() + " average: " + personDto.getAverage());
        }
    }
}
