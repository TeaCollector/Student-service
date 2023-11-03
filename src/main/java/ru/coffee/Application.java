package ru.coffee;

import ru.coffee.domain.dto.PersonDto;
import ru.coffee.domain.model.Person;
import ru.coffee.mapper.PersonMapper;
import ru.coffee.service.ConsoleService;

import java.io.*;


public class Application {

    private final ConsoleService<Person, PersonDto> consoleService;
    private final PersonMapper personMapper;
    private final InputStream pathToFile;

    public Application(ConsoleService<Person, PersonDto> consoleService, PersonMapper personMapper, InputStream pathToFile) {
        this.consoleService = consoleService;
        this.personMapper = personMapper;
        this.pathToFile = pathToFile;
    }

    public void populateDB() {
        String[] personString;
        Person person;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(pathToFile));
            String data;
            data = br.readLine();
            while ((data = br.readLine()) != null) {
                personString = data.split(";");
                PersonDto personDtoFromFile = personMapper.stringToPersonDto(personString);
                person = personMapper.personDtoToPerson(personDtoFromFile);
                consoleService.addPerson(person);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

