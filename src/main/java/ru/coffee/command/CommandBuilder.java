package ru.coffee.command;

import ru.coffee.service.StudentService;

public class CommandBuilder {
    private StudentService studentService;

    public CommandBuilder(StudentService studentService) {
        this.studentService = studentService;
    }

    public <T> void action(Command<T> command, T param) {
        command.execute(param);
    }

}
