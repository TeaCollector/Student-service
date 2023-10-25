package ru.coffee.command;

import ru.coffee.service.GroupCriteria;
import ru.coffee.service.StudentService;

public class CommandBuilder {
    private final StudentService studentService;

    public CommandBuilder(StudentService studentService) {
        this.studentService = studentService;
    }

    public <T> void action(GroupCriteria<T> groupCriteria, Command<T> command, T param) {
        command.execute(groupCriteria, param);
    }

}
