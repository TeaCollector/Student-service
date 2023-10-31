package ru.coffee;

import ru.coffee.config.DBConnection;
import ru.coffee.domain.model.Person;
import ru.coffee.mapper.PersonMapper;
import ru.coffee.repository.Repository;
import ru.coffee.repository.impl.PersonRepositoryImpl;
import ru.coffee.service.Service;
import ru.coffee.service.impl.PersonServiceImpl;


public class Main {
    public static void main(String[] args) {

        DBConnection provider = new DBConnection();

        PersonMapper personMapper = PersonMapper.INSTANCE;

        Repository<Person> repository = new PersonRepositoryImpl(provider);

        Service<Person> personService = new PersonServiceImpl(repository);

        Application application = new Application(personService, personMapper);

        application.run();
    }
}

