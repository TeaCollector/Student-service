package ru.coffee.command;

import ru.coffee.service.Service;

import java.util.List;

public interface CommandWithArgument<T> {

    List<T> execute(Service<T> service, String lastName);

}
