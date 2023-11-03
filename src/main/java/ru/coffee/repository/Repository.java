package ru.coffee.repository;


import java.math.BigDecimal;
import java.util.List;

public interface Repository<T, D> {

    T addPerson(T person);

    List<BigDecimal> averageScore();

    List<D> excellentPerson();

    List<D> personsAverage(String name);

    D changePersonsScore(D personDto);

    List<D> findAverageScoreConcreteClass(int classroom);

}
