package ru.coffee.service;

import ru.coffee.domain.dto.PersonDtoWithServlet;

import java.math.BigDecimal;
import java.util.List;

public interface ConsoleService<T, D> {

    T addPerson(T person);

    List<BigDecimal> averageScore();

    List<D> excellentPerson();

    List<D> personsAverage(String name);

}
