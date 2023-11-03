package ru.coffee.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private String name;
    private String lastName;
    private String lesson;
    private int age;
    private int classroom;
    private int physics;
    private int mathematics;
    private int rus;
    private int literature;
    private int geometry;
    private int informatics;
    private int score;
    private double average;
}
