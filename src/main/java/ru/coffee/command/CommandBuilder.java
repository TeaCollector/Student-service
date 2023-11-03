package ru.coffee.command;

import ru.coffee.service.ConsoleService;
import ru.coffee.service.StudentService;

import java.util.List;

public class CommandBuilder<T, D> {

    private final StudentService studentService;

    public CommandBuilder(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<D> action(ConsoleService<T, D> consoleService, Command<T, D> command) {
        return command.execute(consoleService);
    }

    public List<D> actionWithArgument(ConsoleService<T, D> consoleService, CommandWithArgument<T, D> command, String lastName) {
        return command.execute(consoleService, lastName);
    }
}
