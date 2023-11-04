package ru.coffee.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.coffee.Application;
import ru.coffee.config.DBConnection;
import ru.coffee.domain.dto.PersonDtoWithServlet;
import ru.coffee.mapper.PersonMapper;
import ru.coffee.repository.ConsoleRepository;
import ru.coffee.repository.ServletRepository;
import ru.coffee.repository.impl.PersonConsoleRepositoryImpl;
import ru.coffee.repository.impl.PersonServletRepositoryImpl;
import ru.coffee.service.ConsoleService;
import ru.coffee.service.ServletService;
import ru.coffee.service.impl.PersonConsoleServiceImpl;
import ru.coffee.service.impl.PersonServletServiceImpl;

import java.io.*;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

@WebServlet("/persons")
public class PersonsServlet extends HttpServlet {

    private ConsoleService consoleService;
    private ServletService servletService;
    private boolean DBIsInit = false;

    @Override
    public void init(ServletConfig config) throws ServletException {
        Properties connectionToDb = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream pathToConnection = classLoader.getResourceAsStream("db.properties");
        InputStream pathToScript = classLoader.getResourceAsStream("initdb.sql");
        InputStream pathToFile = classLoader.getResourceAsStream("students.csv");
        StringBuilder sqlScript = new StringBuilder();
        int digit;
        try {
            Class.forName("org.postgresql.Driver");
            while ((digit = pathToScript.read()) != -1) {
                sqlScript.append((char) digit);
            }
            connectionToDb.load(pathToConnection);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        connection = new DBConnection(connectionToDb, sqlScript.toString()).getConnection();
        PersonMapper mapper = PersonMapper.INSTANCE;
        ConsoleRepository consoleRepository = new PersonConsoleRepositoryImpl(connection, mapper);
        ServletRepository servletRepository = new PersonServletRepositoryImpl(connection);
        servletService = new PersonServletServiceImpl(servletRepository);
        consoleService = new PersonConsoleServiceImpl(consoleRepository);
        Application application = new Application(consoleService, mapper, pathToFile);
        if (!DBIsInit) {
            application.populateDB();
            DBIsInit = true;
        }
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
        PersonDtoWithServlet personDto = mapper.readValue(requestBodyString, PersonDtoWithServlet.class);
        servletService.changePersonsScore(personDto);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("application/json");
        out.write(personDto.toString());
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Integer personClass = Integer.valueOf(req.getParameter("class"));
        List<PersonDtoWithServlet> personDtoList = servletService.findAverageScoreConcreteClass(personClass);
        for (PersonDtoWithServlet personDto : personDtoList) {
            out.println(personDto.getName() + " " + personDto.getLastName() + " class: " +
                        personDto.getClassroom() + " average: " + personDto.getAverage());
        }
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
