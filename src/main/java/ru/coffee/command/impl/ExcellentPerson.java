package ru.coffee.command.impl;

import ru.coffee.command.Command;
import ru.coffee.model.Person;
import ru.coffee.service.GroupCriteria;

public class ExcellentPerson implements Command<Integer> {

    @Override
    public void execute(GroupCriteria<Integer> service, Integer param) {
        Person[][] personsArray = {service.getPerson(15),
                                     service.getPerson(16),
                                     service.getPerson(17)};
        int index = 0;
        while (index < 3) {
            Person[] personList = personsArray[index];
            for (Person person : personList) {
                if (person == null) break;
                if (person.getGeometry() == 5 && person.getInformatics() == 5
                    && person.getLiterature() == 5 && person.getMathematics() == 5
                    && person.getRus() == 5 && person.getPhysics() == 5) {
                    System.out.println(person);
                }
            }
            index++;
        }
    }

}
