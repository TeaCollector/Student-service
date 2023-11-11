package ru.coffee.command.impl;

import ru.coffee.command.CommandWithArgument;
import ru.coffee.domain.dto.PersonDto;
import ru.coffee.service.Service;

import java.util.List;

public class FindAverageScoreOfPerson implements CommandWithArgument<PersonDto> {

    @Override
    public List<PersonDto> execute(Service<PersonDto> service, String lastName) {
            return service.personsAverage(lastName);
    }
}
