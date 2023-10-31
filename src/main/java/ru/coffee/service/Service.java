package ru.coffee.service;

import ru.coffee.domain.model.Person;

public interface Service<T> {

    T addPerson(T person);

    Person[] getPerson(T key);

}
