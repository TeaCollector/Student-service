package ru.coffee.repository;

import java.util.List;

public interface ServletRepository<T, D> extends WorkingWithBD {

    D changePersonsScore(D personDto);

    List<D> findAverageScoreConcreteClass(int classroom);

}