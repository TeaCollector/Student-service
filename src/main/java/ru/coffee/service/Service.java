package ru.coffee.service;

import java.math.BigDecimal;
import java.util.List;

public interface Service<T> {

    T addPerson(T person);

    List<BigDecimal> averageScore();

    List<T> excellentPerson();

    List<T> personsAverage(String name);

}
