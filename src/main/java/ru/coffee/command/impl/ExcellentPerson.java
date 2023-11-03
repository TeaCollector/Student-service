package ru.coffee.command.impl;

import ru.coffee.command.Command;
import ru.coffee.domain.dto.PersonDto;
import ru.coffee.domain.model.Person;
import ru.coffee.service.ConsoleService;

import java.util.List;

public class ExcellentPerson implements Command<Person, PersonDto> {

    @Override
    public List<PersonDto> execute(ConsoleService<Person, PersonDto> consoleService) {
        return consoleService.excellentPerson();
    }
}
