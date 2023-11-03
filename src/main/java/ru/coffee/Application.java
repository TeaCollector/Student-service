package ru.coffee;

import ru.coffee.command.Command;
import ru.coffee.command.CommandBuilder;
import ru.coffee.command.CommandWithArgument;
import ru.coffee.command.impl.ExcellentPerson;
import ru.coffee.command.impl.AverageScore;
import ru.coffee.command.impl.FindAverageScoreOfPerson;
import ru.coffee.domain.dto.PersonDto;
import ru.coffee.input.DataLoader;
import ru.coffee.input.impl.DataFromFile;
import ru.coffee.domain.model.Person;
import ru.coffee.mapper.PersonMapper;
import ru.coffee.service.Service;
import ru.coffee.service.StudentService;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;

public class Application {

    private final Service<Person, PersonDto> service;
    private final PersonMapper personMapper;

    public Application(Service<Person, PersonDto> service, PersonMapper personMapper) {
        this.service = service;
        this.personMapper = personMapper;
    }

    /**
     * Здесь studentService читает файл и передает объект Person различным сервисам,
     * а те хранят данные по своему (по классу, по возрасту и по первой букве фамилии
     */
    public void run() {
        DataLoader<BufferedReader> dataLoader = new DataFromFile();
        StudentService studentService = new StudentService(dataLoader);
        String[] personArray;
        Person person;
        try {

            BufferedReader br = studentService.loadData();
            String data;
            data = br.readLine();
            while ((data = br.readLine()) != null) {
//                personArray = data.split(";");
//                PersonDto personDtoFromFile = personMapper.stringToPersonDto(personArray);
//                person = personMapper.personDtoToPerson(personDtoFromFile);
//                service.addPerson(person);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Welcome to our application for\n" +
                         "Here you can find out average score of high school student please input: '1'\n" +
                         "You can find excellent student under 14 y. o. input: '2'\n" +
                         "And finally find out student and his average score on last name input: '3', and then input last name: 'Абрамов' for example\n");


        try (BufferedReader readerFromConsole = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("Input: ");
                String actionFromConsole = readerFromConsole.readLine();
                CommandBuilder commandBuilder = new CommandBuilder(studentService);
                switch (actionFromConsole) {
                    case "1" -> {
                        Command<Person, BigDecimal> avg = new AverageScore();
                        List<BigDecimal> scoreList = commandBuilder.action(service, avg);
                        System.out.println("Average 10 class: " + scoreList.get(0));
                        System.out.println("Average 11 class: " + scoreList.get(1));
                    }
                    case "2" -> {
                        Command<Person, PersonDto> excellent = new ExcellentPerson();
                        List<PersonDto> personDtoList = commandBuilder.action(service, excellent);
                        for (PersonDto personDto : personDtoList) {
                            System.out.println("Name: " + personDto.getName() + " Last name: " + personDto.getLastName());
                        }
                    }
                    case "3" -> {
                        System.out.print("Enter last name: ");
                        String lastName = readerFromConsole.readLine();
                        CommandWithArgument<Person, PersonDto> findPerson = new FindAverageScoreOfPerson();
                        List<PersonDto> list = commandBuilder.actionWithArgument(service, findPerson, lastName);
                        for (PersonDto personDto : list) {
                            System.out.println("Name: " + personDto.getName() + " Last name: " + personDto.getLastName()
                                               + " group: " + personDto.getClassroom() + " average: " + personDto.getAverage());
                        }
                    }
                    default -> {
                        return;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
