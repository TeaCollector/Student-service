package ru.coffee.service.impl;

import ru.coffee.model.Person;
import ru.coffee.service.PersonCriteriaService;

import java.util.*;

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
    public List<Person> getPerson(Integer age) {
        return personMap.get(age);
    }

    public int getPersonMapSize() {
        return personMap.size();
    }
}
