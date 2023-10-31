package ru.coffee.command;

import ru.coffee.service.Service;
import ru.coffee.service.StudentService;

public class CommandBuilder {

    private final StudentService studentService;

    public CommandBuilder(StudentService studentService) {
        this.studentService = studentService;
    }

    public <T> void action(Service<T> service, Command<T> command, T param) {
        command.execute(service, param);
    }

}
