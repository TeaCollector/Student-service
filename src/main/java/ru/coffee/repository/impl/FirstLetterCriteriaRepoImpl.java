package ru.coffee.repository.impl;

import ru.coffee.model.Person;
import ru.coffee.repository.PersonCriteriaRepository;
import ru.coffee.util.Util;

// Реализовал способ хранения данных в двумерном массиве, с точки зрения доступа к данным это занимает О(1)
// Вставка новых элементов занимает О(1) НО! Если наш массив оказывается переполнен,
// происходит создание нового массива и копирование в него элементов из старого. Эта операция занимает O(n)

public class FirstLetterCriteriaRepoImpl implements PersonCriteriaRepository<String> {

    private char[] firstLetterArray;
    private Person[][] personArray;

    public FirstLetterCriteriaRepoImpl() {
        firstLetterArray = new char[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т',
                'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Э', 'Ю', 'Я'};
        int firstLetter = 31;
        int personCount = 1000;
        personArray = new Person[firstLetter][personCount];
    }

    @Override
    public void addPerson(Person param) {
        int positionAtPerson = getPositionAtPersonArray(param);
        Util.fillingArray(param, positionAtPerson, personArray);
    }

    @Override
    public Person[] getPerson(String lastName) {
        char firstLetter = lastName.charAt(0);
        int positionAtPerson = 0;
        while (positionAtPerson < firstLetterArray.length) {
            if (firstLetter == firstLetterArray[positionAtPerson]) break;
            positionAtPerson++;
        }
        return personArray[positionAtPerson];
    }

    @Override
    public boolean keyIsPresent(String lastName) {
        char firstLetter = lastName.charAt(0);
        int positionAtPerson = 0;
        while (positionAtPerson < firstLetterArray.length) {
            if (firstLetter == firstLetterArray[positionAtPerson]) break;
            positionAtPerson++;
        }
        return personArray[positionAtPerson] != null;
    }

    private int getPositionAtPersonArray(Person param) {
        char firstLetter = param.getLastName().charAt(0);
        int positionAtPerson = 0;
        while (positionAtPerson < firstLetterArray.length) {
            if (firstLetter == firstLetterArray[positionAtPerson]) break;
            positionAtPerson++;
        }
        return positionAtPerson;
    }
}
