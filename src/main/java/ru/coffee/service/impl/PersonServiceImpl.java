package ru.coffee.service.impl;

import ru.coffee.domain.dto.PersonDto;
import ru.coffee.domain.model.Person;
import ru.coffee.repository.Repository;
import ru.coffee.service.Service;

import java.math.BigDecimal;
import java.util.List;

public class PersonServiceImpl implements Service<Person, PersonDto> {

    private final Repository<Person, PersonDto> repository;

    public PersonServiceImpl(Repository<Person, PersonDto> repository) {
        this.repository = repository;
    }

    public Person addPerson(Person person) {
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

    @Override
    public PersonDto changePersonsScore(PersonDto personDto) {
        return repository.changePersonsScore(personDto);
    }

    @Override
    public List<PersonDto> findAverageScoreConcreteClass(int classroom) {
        return repository.findAverageScoreConcreteClass(classroom);
    }
}
