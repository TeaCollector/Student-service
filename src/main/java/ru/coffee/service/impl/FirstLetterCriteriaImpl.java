package ru.coffee.service.impl;

import ru.coffee.model.Person;
import ru.coffee.service.PersonCriteriaService;

import java.util.*;

public class FirstLetterCriteriaImpl implements PersonCriteriaService<Character> {

    private Map<Character, List<Person>> personMap = new HashMap<>();

    @Override
    public void addPerson(Person person) {
        if (personMap.containsKey(person.getLastName().charAt(0))) {
            List<Person> personList = personMap.get(person.getLastName().charAt(0));
            personList.add(person);
            personMap.put(person.getLastName().charAt(0), personList);
        } else {
            personMap.put(person.getLastName().charAt(0), new ArrayList<>(Arrays.asList(person)));
        }
    }

    @Override
    public List<Person> getPerson(Character letter) {
        return personMap.get(letter);
    }
}
