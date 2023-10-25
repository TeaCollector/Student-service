package ru.coffee.repository.impl;

import ru.coffee.model.Person;
import ru.coffee.repository.PersonCriteriaRepository;
import ru.coffee.util.Util;

// Реализовал способ хранения данных в двумерном массиве, с точки зрения доступа к данным это занимает О(1)
// Вставка новых элементов занимает О(1) НО! Если наш массив оказывается переполнен,
// происходит создание нового массива и копирование в него элементов из старого. Эта операция занимает O(n)

public class ClassroomRepositoryRepoImpl implements PersonCriteriaRepository<Integer> {

    private final Person[][] personArray;

    public ClassroomRepositoryRepoImpl() {
        int classCount = 12;
        int personCount = 1000;
        personArray = new Person[classCount][personCount];
    }

    @Override
    public void addPerson(Person person) {
        int classNumber = person.getClassroom() - 1;
        Util.fillingArray(person, classNumber, personArray);
    }


    @Override
    public Person[] getPerson(Integer key) {
        return personArray[key - 1];
    }

    @Override
    public boolean keyIsPresent(Integer key) {
        return personArray[key] != null;
    }

}
