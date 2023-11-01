package ru.coffee.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
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
    private double average;

}
