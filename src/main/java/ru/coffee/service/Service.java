package ru.coffee.service;

import ru.coffee.domain.dto.PersonDto;

import java.math.BigDecimal;
import java.util.List;

public interface Service<T, D> {

    T addPerson(T person);

    List<BigDecimal> averageScore();

    List<D> excellentPerson();

    List<D> personsAverage(String name);

    D changePersonsScore(PersonDto personDto);

    List<D> findAverageScoreConcreteClass(int classroom);

}
