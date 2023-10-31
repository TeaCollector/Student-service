package ru.coffee.command.impl;

import ru.coffee.command.Command;
import ru.coffee.domain.model.Person;
import ru.coffee.service.Service;

public class FindPersonCommand implements Command<String> {

    @Override
    public void execute(Service<String> service, String lastName) {
        Person[] personsArray = service.getPerson(lastName);
        for (Person person : personsArray) {
            if (person == null) break;
            if (lastName.equals(person.getLastName())) {
                System.out.println(person);
            }
        }
    }
}
