package ru.coffee;

import ru.coffee.config.DBConnection;
import ru.coffee.repository.PersonCriteriaRepository;
import ru.coffee.repository.impl.AgeCriteriaRepoImpl;
import ru.coffee.repository.impl.ClassroomRepositoryRepoImpl;
import ru.coffee.repository.impl.FirstLetterCriteriaRepoImpl;
import ru.coffee.service.GroupCriteria;
import ru.coffee.service.impl.AgeGroupCriteriaImpl;
import ru.coffee.service.impl.ClassroomCriteriaImpl;
import ru.coffee.service.impl.FirstLetterCriteriaImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


public class Main {
    public static void main(String[] args) {

        Properties properties = new Properties();
        try (InputStreamReader in = new InputStreamReader(new FileInputStream("src/main/resources/db.properties"))) {
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DBConnection provider = new DBConnection(properties.getProperty("jdbc.postgres.url"),
                properties.getProperty("jdbc.postgres.username"), properties.getProperty("jdbc.postgres.password"));


        System.exit(0);




        PersonCriteriaRepository<String> firstLetterRepo = new FirstLetterCriteriaRepoImpl();
        PersonCriteriaRepository<Integer> classroomRepo = new ClassroomRepositoryRepoImpl();
        PersonCriteriaRepository<Integer> ageRepo = new AgeCriteriaRepoImpl();

        GroupCriteria<String> firstLetterService = new FirstLetterCriteriaImpl(firstLetterRepo);
        GroupCriteria<Integer> classroomService = new ClassroomCriteriaImpl(classroomRepo);
        GroupCriteria<Integer> ageService = new AgeGroupCriteriaImpl(ageRepo);

        Application application = new Application(ageService, classroomService, firstLetterService);
    }
}

