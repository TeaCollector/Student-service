package ru.coffee.service.impl;

import ru.coffee.model.Person;
import ru.coffee.repository.PersonCriteriaRepository;
import ru.coffee.service.PersonCriteriaService;
import ru.coffee.util.Util;

public class AgePersonCriteriaImpl implements PersonCriteriaService<Integer> {


    private PersonCriteriaRepository<Integer> criteriaRepository;
    private Util util;

    public AgePersonCriteriaImpl(PersonCriteriaRepository<Integer> criteriaRepository, Util util) {
        this.criteriaRepository = criteriaRepository;
        this.util = util;
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

    public void actionWithPerson(Integer digit) {
        Person[][] arrayWithPersonUnder14yo = {getPerson(15),getPerson(16),getPerson(17)};
        util.findExcellentStudent(arrayWithPersonUnder14yo);
    }
}
