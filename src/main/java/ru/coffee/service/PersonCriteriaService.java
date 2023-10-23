package ru.coffee.service;

import ru.coffee.model.Person;

public interface PersonCriteriaService<T> {

    void addPerson(Person person);

    Person[] getPerson(T key);

    boolean keyIsPresent(T key);

    void actionWithPerson(T param);
}
