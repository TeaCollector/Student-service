package ru.coffee.repository;

import java.util.List;

public interface ServletRepository<T, D> {

    D changePersonsScore(D personDto);

    List<D> findAverageScoreConcreteClass(int classroom);

}