package ru.coffee.service.impl;

import ru.coffee.domain.dto.PersonDto;
import ru.coffee.domain.model.Person;
import ru.coffee.repository.ConsoleRepository;
import ru.coffee.service.ConsoleService;

import java.math.BigDecimal;
import java.util.List;

public class PersonConsoleServiceImpl implements ConsoleService<Person, PersonDto> {

    private final ConsoleRepository<Person, PersonDto> consoleRepository;

    public PersonConsoleServiceImpl(ConsoleRepository<Person, PersonDto> consoleRepository) {
        this.consoleRepository = consoleRepository;
    }

    public Person addPerson(Person person) {
        consoleRepository.addPerson(person);
        return person;
    }

    @Override
    public List<BigDecimal> averageScore() {
        return consoleRepository.averageScore();
    }

    @Override
    public List<PersonDto> excellentPerson() {
        return consoleRepository.excellentPerson();
    }

    @Override
    public List<PersonDto> personsAverage(String name) {
        return consoleRepository.personsAverage(name);
    }

}
