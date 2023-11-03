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
public class PersonDtoWithServlet {
    private String name;
    private String lastName;
    private String lesson;
    private int classroom;
    private int score;
    private double average;
}
