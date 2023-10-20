package ru.coffee.controller;

import ru.coffee.model.Person;
import ru.coffee.service.PersonCriteriaService;
import ru.coffee.util.Util;

import java.io.*;

public class ActionWithPersonController {

    private Util util;
    private PersonCriteriaService<Integer> ageCriteria;
    private PersonCriteriaService<Integer> classroomCriteria;
    private PersonCriteriaService<Character> firstLetterCriteria;

    public ActionWithPersonController(Util util, PersonCriteriaService<Integer> ageCriteria,
                                      PersonCriteriaService<Integer> classroomCriteria,
                                      PersonCriteriaService<Character> firstLetterCriteria) {
        this.util = util;
        this.ageCriteria = ageCriteria;
        this.classroomCriteria = classroomCriteria;
        this.firstLetterCriteria = firstLetterCriteria;
    }


    public void run() {
        String[] personArray;
        Person person;
        try (BufferedReader readerFromFile = new BufferedReader(new FileReader("students.csv"))) {
            String readLineFromFile = readerFromFile.readLine();
            while ((readLineFromFile = readerFromFile.readLine()) != null) {
                personArray = readLineFromFile.split(";");
                person = new Person();
                mapToPerson(personArray, person);

                ageCriteria.addPerson(person);
                classroomCriteria.addPerson(person);
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
                switch (actionFromConsole) {
                    case "1" -> util.averageScoreHighSchoolStudent();
                    case "2" -> util.findExcellentStudent();
                    case "3" -> {
                        System.out.print("Enter last name: ");
                        String lastName = readerFromConsole.readLine();
                        util.findStudent(lastName);
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
