package ru.coffee.service;

import ru.coffee.model.Person;

public interface GroupCriteria<T> {

    void addPerson(Person person);

    Person[] getPerson(T key);

    boolean keyIsPresent(T key);

}
