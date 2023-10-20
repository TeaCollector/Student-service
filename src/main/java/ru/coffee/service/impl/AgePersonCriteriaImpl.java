package ru.coffee.service.impl;

import ru.coffee.model.Person;
import ru.coffee.service.PersonCriteriaService;

import java.util.*;

// Решил сделать через готовую реализацию HashMap, по 'О' нотации сложность доступа к элементам будет
// константой, добавление элементов будет так же O(1), что является самым быстрым вариантов из всех возможных.

public class AgePersonCriteriaImpl implements PersonCriteriaService<Integer> {

    private Map<Integer, List<Person>> personMap = new HashMap<>();

    @Override
    public void addPerson(Person person) {
        if (personMap.containsKey(person.getAge())) {
            List<Person> personList = personMap.get(person.getAge());
            personList.add(person);
            personMap.put(person.getAge(), personList);
        } else {
            personMap.put(person.getAge(), new ArrayList<>(Arrays.asList(person)));
        }
    }

    @Override
    public List<Person> getPerson(Integer key) {
        return personMap.get(key);
    }

    @Override
    public boolean keyIsPresent(Integer age) {
        return personMap.containsKey(age);
    }
}
