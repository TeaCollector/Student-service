package ru.coffee.util;

import ru.coffee.model.Person;

public class Util {

    public void averageScoreHighSchoolStudent(Person[] person10class, Person[] person11class) {
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

    public void findExcellentStudent(Person[][] personsArray) {
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

    public void findPerson(Person[] personsArray, String lastName) {
        for (Person person : personsArray) {
            if (person == null) break;
            if (lastName.equals(person.getLastName())) {
                System.out.println(person);
            }
        }
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
    }

    public static void fillingArray(Person param, int positionAtPerson, Person[][] personArray) {
        Person[] personWithFirstLetter = personArray[positionAtPerson];
        int indexForInsert = 0;
        Person forChecking = personWithFirstLetter[indexForInsert];
        while (forChecking != null) {
            ++indexForInsert;
            if (indexForInsert == personWithFirstLetter.length - 1) {
                Person[] newPersonArray = new Person[personWithFirstLetter.length + 100];
                System.arraycopy(personWithFirstLetter, 0, newPersonArray, 0, personWithFirstLetter.length);
                personArray[positionAtPerson] = newPersonArray;
            }
            forChecking = personWithFirstLetter[indexForInsert];
        }
        personArray[positionAtPerson][indexForInsert] = param;
    }
}