package ru.coffee.command.impl;

import ru.coffee.command.Command;
import ru.coffee.domain.model.Person;
import ru.coffee.service.ConsoleService;

import java.math.BigDecimal;
import java.util.List;

public class AverageScore implements Command<Person, BigDecimal> {

    @Override
    public List<BigDecimal> execute(ConsoleService<Person, BigDecimal> consoleService) {
        return consoleService.averageScore();
    }
}
