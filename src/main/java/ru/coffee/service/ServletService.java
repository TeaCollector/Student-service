package ru.coffee.service;

import ru.coffee.domain.dto.PersonDtoWithServlet;

import java.util.List;

public interface ServletService<T, D> {

    D changePersonsScore(PersonDtoWithServlet personDto);

    List<D> findAverageScoreConcreteClass(int classroom);

}
