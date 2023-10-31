package ru.coffee.command;

import ru.coffee.service.Service;

public interface Command<T> {
    void execute(Service<T> service, T param);
}
