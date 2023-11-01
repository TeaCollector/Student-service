package ru.coffee.command;

import ru.coffee.service.Service;

import java.util.List;

public interface Command<T, D> {

    List<D> execute(Service<T, D> service);
}
