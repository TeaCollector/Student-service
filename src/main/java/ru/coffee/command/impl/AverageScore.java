package ru.coffee.command.impl;

import ru.coffee.command.Command;
import ru.coffee.model.Person;
import ru.coffee.service.GroupCriteria;

public class AverageScore implements Command<Integer> {

    @Override
    public void execute(GroupCriteria<Integer> service, Integer param) {
        Person[] person10class = service.getPerson(10);
        Person[] person11class = service.getPerson(11);
        double avgOfAllPerson = 0;
        int sizeOfArray = 0;
        for (Person person : person10class) {
            if (person == null) break;
            double avgScore = getAvgScoreOfPerson(person);
            avgOfAllPerson += avgScore;
            sizeOfArray++;
        }

        avgOfAllPerson /= sizeOfArray;
        System.out.println("\nAverage grade on 10 class is: " + avgOfAllPerson);

        sizeOfArray = 0;
        avgOfAllPerson = 0;

        for (Person person : person11class) {
            if (person == null) break;
            double avgScore = getAvgScoreOfPerson(person);
            avgOfAllPerson += avgScore;
            sizeOfArray++;
        }

        avgOfAllPerson /= person11class.length;
        System.out.println("Average grade on 11 class is: " + avgOfAllPerson);

    }

    private double getAvgScoreOfPerson(Person person) {
        double avgScore = 0;
        avgScore += person.getGeometry();
        avgScore += person.getInformatics();
        avgScore += person.getLiterature();
        avgScore += person.getPhysics();
        avgScore += person.getMathematics();
        avgScore += person.getRus();
        avgScore /= 6;
        return avgScore;
    }}
