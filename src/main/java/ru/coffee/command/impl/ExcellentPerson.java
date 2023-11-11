package ru.coffee.command.impl;

import ru.coffee.command.Command;
import ru.coffee.domain.dto.PersonDto;
import ru.coffee.service.Service;

import java.util.List;

public class ExcellentPerson implements Command<PersonDto> {

    @Override
    public List<PersonDto> execute(Service<PersonDto> service) {
        return service.excellentPerson();
    }
}
