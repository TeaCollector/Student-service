package ru.coffee.repository;

import ru.coffee.model.Person;

public interface PersonCriteriaRepository<T> {

    void addPerson(Person param);

    Person[] getPerson(T key);

    boolean keyIsPresent(T key);
}
