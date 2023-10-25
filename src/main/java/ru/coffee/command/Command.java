package ru.coffee.command;

import ru.coffee.service.GroupCriteria;

public interface Command<T> {
    void execute(GroupCriteria<T> groupCriteria, T param);
}
