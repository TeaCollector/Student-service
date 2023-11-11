package ru.coffee.service.impl;

import ru.coffee.domain.dto.PersonDto;
import ru.coffee.repository.Repository;
import ru.coffee.service.Service;

import java.math.BigDecimal;
import java.util.List;

public class PersonServiceImpl implements Service<PersonDto> {

    private final Repository<PersonDto> repository;

    public PersonServiceImpl(Repository<PersonDto> repository) {
        this.repository = repository;
    }

    public PersonDto addPerson(PersonDto person) {
        repository.addPerson(person);
        return person;
    }

    @Override
    public List<BigDecimal> averageScore() {
        return repository.averageScore();
    }

    @Override
    public List<PersonDto> excellentPerson() {
        return repository.excellentPerson();
    }

    @Override
    public List<PersonDto> personsAverage(String name) {
        return repository.personsAverage(name);
    }
}
