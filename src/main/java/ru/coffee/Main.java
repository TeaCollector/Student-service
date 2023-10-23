package ru.coffee;

import ru.coffee.controller.ActionWithPersonController;
import ru.coffee.repository.PersonCriteriaRepository;
import ru.coffee.repository.impl.AgeCriteriaRepoImpl;
import ru.coffee.repository.impl.ClassroomRepositoryRepoImpl;
import ru.coffee.repository.impl.FirstLetterCriteriaRepoImpl;
import ru.coffee.service.PersonCriteriaService;
import ru.coffee.service.impl.AgePersonCriteriaImpl;
import ru.coffee.service.impl.ClassroomCriteriaServiceImpl;
import ru.coffee.service.impl.FirstLetterCriteriaImpl;
import ru.coffee.util.Util;

public class Main {
    public static void main(String[] args) {
        PersonCriteriaRepository<Integer> classroom = new ClassroomRepositoryRepoImpl();
        PersonCriteriaRepository<String> firstLetter = new FirstLetterCriteriaRepoImpl();
        PersonCriteriaRepository<Integer> age = new AgeCriteriaRepoImpl();
        Util util = new Util();

        PersonCriteriaService<Integer> classroomCriteria = new ClassroomCriteriaServiceImpl(classroom, util);
        PersonCriteriaService<String> firstLetterCriteria = new FirstLetterCriteriaImpl(firstLetter, util);
        PersonCriteriaService<Integer> agePersonCriteria = new AgePersonCriteriaImpl(age, util);

        ActionWithPersonController actionWithPersonController = new ActionWithPersonController(agePersonCriteria,
                classroomCriteria, firstLetterCriteria);

        actionWithPersonController.run();

    }
}