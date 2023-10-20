package ru.coffee.util;

import ru.coffee.model.Person;
import ru.coffee.service.PersonCriteriaService;
import ru.coffee.service.impl.AgePersonCriteriaImpl;

import java.util.ArrayList;
import java.util.List;

public class Util {

    private PersonCriteriaService<Integer> classroomCriteria;
    private AgePersonCriteriaImpl ageCriteria;
    private PersonCriteriaService<Character> firstLetterCriteria;

    public Util(PersonCriteriaService<Integer> classroomCriteria,
                AgePersonCriteriaImpl ageCriteria,
                PersonCriteriaService<Character> firstLetterCriteria) {
        this.classroomCriteria = classroomCriteria;
        this.ageCriteria = ageCriteria;
        this.firstLetterCriteria = firstLetterCriteria;
    }


    public void averageScoreHighSchoolStudent() {
        List<Person> personList10class = classroomCriteria.getPerson(9);
        List<Person> personList11class = classroomCriteria.getPerson(11);
        double avgScore = 0;
        for (int i = 0; i < personList10class.size(); i++) {
            avgScore = getAvgScore(personList10class, avgScore, i);
        }

        avgScore /= personList10class.size();
        System.out.println("\nAverage grade on 10 class is: " + avgScore);

        // Rounding:
//        String formattedDouble = new DecimalFormat("#0.00").format(avgScore);
//        System.out.println("\nAverage grade

        avgScore = 0;
        for (int i = 0; i < personList11class.size(); i++) {
            avgScore = getAvgScore(personList10class, avgScore, i);
        }

        // Rounding:
//        String formattedDouble = new DecimalFormat("#0.00").format(avgScore);
//        System.out.println("\nAverage grade on 10 class is: " + formattedDouble);
        avgScore /= personList11class.size();
        System.out.println("Average grade on 11 class on Geometry: " + avgScore);

    }

    //    2) Поиск всех отличников, старше 14 лет
    public void findExcellentStudent() {
        List<Person> listWithExcellentPerson = new ArrayList<>();
        int age = 15;
        while (ageCriteria.ageIsPresent(age)) {
            List<Person> personList = ageCriteria.getPerson(age);
            for (Person person : personList) {
                if (person.getGeometry() == 5 && person.getInformatics() == 5
                    && person.getLiterature() == 5 && person.getMathematics() == 5
                    && person.getRus() == 5 && person.getPhysics() == 5) {
                    listWithExcellentPerson.add(person);
                }
            }
            age++;
        }
        System.out.println(listWithExcellentPerson);
    }

    //    3) Поиск ученика по фамилии (фамилия ученика задается через консоль)
    public void findStudent(String lastName) {
        char firstLetterInputLastName = lastName.charAt(0);


    }



    private double getAvgScore(List<Person> personList10class, double avgScore, int i) {
        double averageOnePerson = 0;
        Person person = personList10class.get(i);
        averageOnePerson += person.getGeometry();
        averageOnePerson += person.getInformatics();
        averageOnePerson += person.getLiterature();
        averageOnePerson += person.getPhysics();
        averageOnePerson += person.getMathematics();
        averageOnePerson += person.getRus();
        avgScore = avgScore + averageOnePerson / 6;
        return avgScore;
    }
}
