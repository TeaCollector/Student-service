package ru.coffee.service.impl;

import ru.coffee.model.Person;
import ru.coffee.repository.PersonCriteriaRepository;
import ru.coffee.service.GroupCriteria;

public class ClassroomCriteriaImpl implements GroupCriteria<Integer> {

    private PersonCriteriaRepository<Integer> criteriaRepository;

    public ClassroomCriteriaImpl(PersonCriteriaRepository<Integer> criteriaRepository) {
        this.criteriaRepository = criteriaRepository;
    }

    @Override
    public void addPerson(Person person) {
        criteriaRepository.addPerson(person);
    }

    @Override
    public Person[] getPerson(Integer key) {
        return criteriaRepository.getPerson(key);
    }

    @Override
    public boolean keyIsPresent(Integer key) {
        return criteriaRepository.keyIsPresent(key);
    }

}

