package ru.coffee.command;

import ru.coffee.service.Service;
import ru.coffee.service.StudentService;

import java.util.List;

public class CommandBuilder<T, D> {

    private final StudentService studentService;

    public CommandBuilder(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<D> action(Service<T, D> service, Command<T, D> command) {
        return command.execute(service);
    }

    public List<D> actionWithArgument(Service<T, D> service, CommandWithArgument<T, D> command, String lastName) {
        return command.execute(service, lastName);
    }
}
