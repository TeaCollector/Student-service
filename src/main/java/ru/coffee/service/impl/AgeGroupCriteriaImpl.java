package ru.coffee.service.impl;

import ru.coffee.model.Person;
import ru.coffee.repository.PersonCriteriaRepository;
import ru.coffee.service.GroupCriteria;

public class AgeGroupCriteriaImpl implements GroupCriteria<Integer> {

    private PersonCriteriaRepository<Integer> criteriaRepository;

    public AgeGroupCriteriaImpl(PersonCriteriaRepository<Integer> criteriaRepository) {
        this.criteriaRepository = criteriaRepository;

    }

    public void addPerson(Person person) {
        criteriaRepository.addPerson(person);
    }

    @Override
    public Person[] getPerson(Integer key) {
        return criteriaRepository.getPerson(key);
    }

    @Override
    public boolean keyIsPresent(Integer age) {
        return criteriaRepository.keyIsPresent(age);
    }

}
