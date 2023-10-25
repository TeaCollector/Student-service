package ru.coffee;

import ru.coffee.repository.PersonCriteriaRepository;
import ru.coffee.repository.impl.AgeCriteriaRepoImpl;
import ru.coffee.repository.impl.ClassroomRepositoryRepoImpl;
import ru.coffee.repository.impl.FirstLetterCriteriaRepoImpl;
import ru.coffee.service.GroupCriteria;
import ru.coffee.service.impl.AgeGroupCriteriaImpl;
import ru.coffee.service.impl.ClassroomCriteriaImpl;
import ru.coffee.service.impl.FirstLetterCriteriaImpl;

public class Main {
    public static void main(String[] args) {
        PersonCriteriaRepository<String> firstLetterRepo = new FirstLetterCriteriaRepoImpl();
        PersonCriteriaRepository<Integer> classroomRepo = new ClassroomRepositoryRepoImpl();
        PersonCriteriaRepository<Integer> ageRepo = new AgeCriteriaRepoImpl();

        GroupCriteria<String> firstLetterService = new FirstLetterCriteriaImpl(firstLetterRepo);
        GroupCriteria<Integer> classroomService = new ClassroomCriteriaImpl(classroomRepo);
        GroupCriteria<Integer> ageService = new AgeGroupCriteriaImpl(ageRepo);

        DataGroup<String> firstNameGroup = new DataGroup<>(firstLetterService);
        DataGroup<Integer> classroomGroup = new DataGroup<>(classroomService);
        DataGroup<Integer> ageGroup = new DataGroup<>(ageService);

        firstNameGroup.run();




    }
}