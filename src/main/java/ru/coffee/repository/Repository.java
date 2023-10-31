package ru.coffee.repository;

public interface Repository<T> {
    T addPerson(T person);
}
