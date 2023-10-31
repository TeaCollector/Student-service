package ru.coffee.service.impl;

import ru.coffee.domain.model.Person;
import ru.coffee.repository.Repository;
import ru.coffee.service.Service;

public class PersonServiceImpl implements Service<Person> {

    private final Repository repository;

    public PersonServiceImpl(Repository repository) {
        this.repository = repository;
    }

    public Person addPerson(Person person) {
        repository.addPerson(person);
        return person;
    }

    @Override
    public Person[] getPerson(Person key) {
        return new Person[0];
    }
}
