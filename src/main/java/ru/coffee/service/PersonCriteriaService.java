package ru.coffee.service;

import ru.coffee.model.Person;

import java.util.List;

public interface PersonCriteriaService<T> {

    void addPerson(Person person);

    List<Person> getPerson(T key);

    boolean keyIsPresent(T key);
}
