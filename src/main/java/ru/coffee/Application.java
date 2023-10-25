package ru.coffee;

import ru.coffee.command.Command;
import ru.coffee.command.CommandBuilder;
import ru.coffee.command.impl.ExcellentPerson;
import ru.coffee.command.impl.AverageScore;
import ru.coffee.command.impl.FindPersonCommand;
import ru.coffee.input.DataLoader;
import ru.coffee.input.impl.DataFromFile;
import ru.coffee.model.Person;
import ru.coffee.service.GroupCriteria;
import ru.coffee.service.StudentService;

import java.io.*;

public class Application {

    private final GroupCriteria<Integer> ageCriteria;
    private final GroupCriteria<Integer> classroomCriteria;
    private final GroupCriteria<String> firstLetterCriteria;

    public Application(GroupCriteria<Integer> ageCriteria,
                       GroupCriteria<Integer> classroomCriteria,
                       GroupCriteria<String> firstLetterCriteria) {
        this.ageCriteria = ageCriteria;
        this.classroomCriteria = classroomCriteria;
        this.firstLetterCriteria = firstLetterCriteria;
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
            String data = br.readLine();
            while ((data = br.readLine()) != null) {
                personArray = data.split(";");
                person = new Person();
                mapToPerson(personArray, person);
                classroomCriteria.addPerson(person);
                ageCriteria.addPerson(person);
                firstLetterCriteria.addPerson(person);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Welcome to our application for\n" +
                         "Here you can find out average score of high school student please input: '1'\n" +
                         "You can find excellent student under 14 y. o. input: '2'\n" +
                         "And finally find out student on last name input: '3', and then input last name: 'Абрамов' for example\n");


        try (BufferedReader readerFromConsole = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("Input: ");
                String actionFromConsole = readerFromConsole.readLine();
                CommandBuilder commandBuilder = new CommandBuilder(studentService);
                switch (actionFromConsole) {
                    case "1" -> {
                        Command<Integer> avg = new AverageScore();
                        commandBuilder.action(classroomCriteria, avg, 0);
                    }
                    case "2" -> {
                        Command<Integer> excellent = new ExcellentPerson();
                        commandBuilder.action(ageCriteria, excellent, 0);
                    }
                    case "3" -> {
                        System.out.print("Enter last name: ");
                        String lastName = readerFromConsole.readLine();
                        Command<String> findPerson = new FindPersonCommand();
                        commandBuilder.action(firstLetterCriteria, findPerson, lastName);
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

    private void mapToPerson(String[] personArray, Person person) {
        person.setLastName(personArray[0]);
        person.setName(personArray[1]);
        person.setAge(Integer.parseInt(personArray[2]));
        person.setClassroom(Integer.parseInt(personArray[3]));
        person.setPhysics(Integer.parseInt(personArray[4]));
        person.setMathematics(Integer.parseInt(personArray[5]));
        person.setRus(Integer.parseInt(personArray[6]));
        person.setLiterature(Integer.parseInt(personArray[7]));
        person.setGeometry(Integer.parseInt(personArray[8]));
        person.setInformatics(Integer.parseInt(personArray[9]));
    }
}
