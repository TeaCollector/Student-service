package ru.coffee.util;

import ru.coffee.model.Person;

public class Util {

    public void averageScoreHighSchoolStudent(Person[] person10class, Person[] person11class) {

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