package ru.coffee.command.impl;

import ru.coffee.command.CommandWithArgument;
import ru.coffee.domain.dto.PersonDto;
import ru.coffee.domain.model.Person;
import ru.coffee.service.Service;

import java.util.List;

public class FindAverageScoreOfPerson implements CommandWithArgument<Person, PersonDto> {

    @Override
    public List<PersonDto> execute(Service<Person, PersonDto> service, String lastName) {
            return service.personsAverage(lastName);
    }
}
