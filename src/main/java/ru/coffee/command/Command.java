package ru.coffee.command;

import ru.coffee.service.Service;

import java.util.List;

public interface Command<T> {

    List<?> execute(Service<T> service);
}
