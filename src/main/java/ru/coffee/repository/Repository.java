package ru.coffee.repository;


import java.math.BigDecimal;
import java.util.List;

public interface Repository<T> {

    T addPerson(T person);

    List<BigDecimal> averageScore();

    List<T> excellentPerson();

    List<T> personsAverage(String name);
}
