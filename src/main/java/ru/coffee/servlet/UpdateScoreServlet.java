package ru.coffee.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.coffee.domain.dto.PersonDto;

import java.io.IOException;
import java.io.PrintWriter;

//Изменение оценки конкретного ученика (по ФИО и классу) и конкретного предмета

@WebServlet("/update-person")
public class UpdateScoreServlet extends HttpServlet {



    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getHeader("name");
        String lastName = req.getHeader("lastname");
        String lesson = req.getHeader("lesson");
        int personClass = Integer.parseInt(req.getHeader("class"));
        int score = Integer.parseInt(req.getHeader("score"));

        PersonDto personDto = PersonDto.builder()
                .name(name)
                .lastName(lastName)
                .classroom(personClass)
                .build();

        switch (lesson) {
            case "rus" -> personDto.setRus(score);
            case "physic" -> personDto.setPhysics(score);
            case "mathematics" -> personDto.setMathematics(score);
            case "literature" -> personDto.setLiterature(score);
            case "geometry" -> personDto.setGeometry(score);
            case "informatics" -> personDto.setInformatics(score);
        }

//        repository.changeScore(personDto);

        PrintWriter out = resp.getWriter();
        out.write(personDto.getName());
        out.write(personDto.getLastName());
        out.write(personDto.getClassroom());
        out.
        out.flush();
//        out.write(personDto.get);
//        out.write(personDto.getName());

    }
}
