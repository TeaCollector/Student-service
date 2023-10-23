package ru.coffee.service.impl;

import ru.coffee.model.Person;
import ru.coffee.repository.PersonCriteriaRepository;
import ru.coffee.service.PersonCriteriaService;
import ru.coffee.util.Util;

public class ClassroomCriteriaServiceImpl implements PersonCriteriaService<Integer> {

    private PersonCriteriaRepository criteriaRepository;
    private Util util;

    public ClassroomCriteriaServiceImpl(PersonCriteriaRepository criteriaRepository, Util util) {
        this.criteriaRepository = criteriaRepository;
        this.util = util;
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

    public void actionWithPerson(Integer digit) {
       util.averageScoreHighSchoolStudent(getPerson(10), getPerson(11));
    }
}
