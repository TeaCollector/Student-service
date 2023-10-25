package ru.coffee.command.impl;

import ru.coffee.command.Command;
import ru.coffee.model.Person;
import ru.coffee.service.GroupCriteria;

public class FindPersonCommand implements Command<String> {

    @Override
    public void execute(GroupCriteria<String> groupCriteria, String lastName) {
        Person[] personsArray = groupCriteria.getPerson(lastName);
        for (Person person : personsArray) {
            if (person == null) break;
            if (lastName.equals(person.getLastName())) {
                System.out.println(person);
            }
        }
    }
}
