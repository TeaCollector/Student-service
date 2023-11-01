package ru.coffee.command;

import ru.coffee.service.Service;

import java.util.List;

public interface CommandWithArgument<T, D> {

    List<D> execute(Service<T, D> service, String lastName);

}
