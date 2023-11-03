package ru.coffee.command;

import ru.coffee.service.ConsoleService;

import java.util.List;

public interface Command<T, D> {

    List<D> execute(ConsoleService<T, D> consoleService);
}
