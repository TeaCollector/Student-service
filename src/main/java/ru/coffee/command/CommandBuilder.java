package ru.coffee.command;

import ru.coffee.service.Service;
import ru.coffee.service.StudentService;

import java.util.List;

public class CommandBuilder<T, D> {

    private final StudentService studentService;

    public CommandBuilder(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<?> action(Service<T> service, Command<T> command) {
        return command.execute(service);
    }

    public List<T> actionWithArgument(Service<T> service, CommandWithArgument<T> command, String lastName) {
        return command.execute(service, lastName);
    }
}
