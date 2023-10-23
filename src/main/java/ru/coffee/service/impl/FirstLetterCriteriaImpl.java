package ru.coffee.service.impl;

import ru.coffee.model.Person;
import ru.coffee.repository.PersonCriteriaRepository;
import ru.coffee.service.PersonCriteriaService;
import ru.coffee.util.Util;

public class FirstLetterCriteriaImpl implements PersonCriteriaService<String> {

    private PersonCriteriaRepository criteriaRepository;
    private Util util;

    public FirstLetterCriteriaImpl(PersonCriteriaRepository criteriaRepository, Util util) {
        this.criteriaRepository = criteriaRepository;
        this.util = util;
    }

    @Override
    public void addPerson(Person person) {
        criteriaRepository.addPerson(person);
    }

    @Override
    public Person[] getPerson(String lastName) {
        return criteriaRepository.getPerson(lastName);
    }

    @Override
    public boolean keyIsPresent(String lastName) {
        return criteriaRepository.keyIsPresent(lastName);
    }

    public void actionWithPerson(String lastName) {
        util.findPerson(getPerson(lastName), lastName);
    }
}
