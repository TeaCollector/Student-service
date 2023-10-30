package ru.coffee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Person {

    private String name;
    private String lastName;
    private int age;
    private int classroom;
    private int physics;
    private int mathematics;
    private int rus;
    private int literature;
    private int geometry;
    private int informatics;

    public Person(String name, String lastName, int age, int classroom) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.classroom = classroom;
    }
}
