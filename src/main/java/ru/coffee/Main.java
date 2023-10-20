package ru.coffee;

import ru.coffee.controller.ActionWithPersonController;
import ru.coffee.service.PersonCriteriaService;
import ru.coffee.service.impl.AgePersonCriteriaImpl;
import ru.coffee.service.impl.ClassroomPersonCriteriaImpl;
import ru.coffee.service.impl.FirstLetterCriteriaImpl;
import ru.coffee.util.Util;

public class Main {
    public static void main(String[] args) {
        PersonCriteriaService<Integer> classroomCriteria = new ClassroomPersonCriteriaImpl();
        AgePersonCriteriaImpl agePersonCriteria = new AgePersonCriteriaImpl();
        PersonCriteriaService<Character> firstLetterCriteria = new FirstLetterCriteriaImpl();
        Util utils = new Util(classroomCriteria, agePersonCriteria, firstLetterCriteria);
        ActionWithPersonController actionWithPersonController =
                new ActionWithPersonController(utils, agePersonCriteria,
                        classroomCriteria, firstLetterCriteria);
        actionWithPersonController.run();

    }
}