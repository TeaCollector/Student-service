package ru.coffee.service;

import java.math.BigDecimal;
import java.util.List;

public interface Service<T, D> {

    T addPerson(T person);

    List<BigDecimal> averageScore();

    List<D> excellentPerson();

    List<D> personsAverage(String name);

}
