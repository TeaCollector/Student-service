package ru.coffee.service.impl;

import ru.coffee.domain.dto.PersonDtoWithServlet;
import ru.coffee.domain.model.Person;
import ru.coffee.repository.ServletRepository;
import ru.coffee.service.ServletService;

import java.util.List;

public class PersonServletServiceImpl implements ServletService<Person, PersonDtoWithServlet> {

    private ServletRepository<Person, PersonDtoWithServlet> repository;

    public PersonServletServiceImpl(ServletRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonDtoWithServlet changePersonsScore(PersonDtoWithServlet personDto) {
        return repository.changePersonsScore(personDto);
    }

    @Override
    public List<PersonDtoWithServlet> findAverageScoreConcreteClass(int classroom) {
        return repository.findAverageScoreConcreteClass(classroom);
    }
}
