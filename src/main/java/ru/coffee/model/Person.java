package ru.coffee.model;

import java.util.Objects;

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


    public Person() {
    }

    public Person(String name, String lastName, int age, int classroom) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.classroom = classroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getMathematics() {
        return mathematics;
    }

    public void setMathematics(int mathematics) {
        this.mathematics = mathematics;
    }

    public int getRus() {
        return rus;
    }

    public void setRus(int rus) {
        this.rus = rus;
    }

    public int getLiterature() {
        return literature;
    }

    public void setLiterature(int literature) {
        this.literature = literature;
    }

    public int getGeometry() {
        return geometry;
    }

    public void setGeometry(int geometry) {
        this.geometry = geometry;
    }

    public int getInformatics() {
        return informatics;
    }

    public void setInformatics(int informatics) {
        this.informatics = informatics;
    }

    @Override
    public String toString() {
        return name + " " + lastName + ", класс: " + classroom + ", возраст: " + age + ";";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && classroom == person.classroom &&
               physics == person.physics && mathematics == person.mathematics &&
               rus == person.rus && literature == person.literature &&
               geometry == person.geometry && informatics == person.informatics &&
               Objects.equals(name, person.name) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classroom);
    }
}
