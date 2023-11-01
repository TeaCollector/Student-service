package ru.coffee.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.coffee.domain.model.Person;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


//Получения средних оценок каждого ученика в указанном классе


@WebServlet(urlPatterns = {"/hello"})
public class AvgScoreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Integer personClass = Integer.valueOf(req.getParameter("class"));
//        List<Person> averageList = repository.getAverageScore(personClass);
//        for (Person person : averageList) {
//            out.write(person.getName() + " " + person.getLastName() + ": " + person.getAverage());
//        }
        out.println(personClass);
    }
}
