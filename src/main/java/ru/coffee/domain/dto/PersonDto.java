package ru.coffee.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto {
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
