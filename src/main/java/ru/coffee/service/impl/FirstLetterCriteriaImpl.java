package ru.coffee.service.impl;

import ru.coffee.model.Person;
import ru.coffee.repository.PersonCriteriaRepository;
import ru.coffee.service.GroupCriteria;

public class FirstLetterCriteriaImpl implements GroupCriteria<String> {

    private PersonCriteriaRepository<String> criteriaRepository;

    public FirstLetterCriteriaImpl(PersonCriteriaRepository<String> criteriaRepository) {
        this.criteriaRepository = criteriaRepository;
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

}
