package ru.coffee.command.impl;

import ru.coffee.command.Command;
import ru.coffee.domain.dto.PersonDto;
import ru.coffee.service.Service;

import java.math.BigDecimal;
import java.util.List;

public class AverageScore implements Command<PersonDto> {

    @Override
    public List<BigDecimal> execute(Service<PersonDto> service) {
        return service.averageScore();
    }
}
