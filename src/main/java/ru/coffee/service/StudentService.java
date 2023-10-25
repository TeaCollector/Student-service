package ru.coffee.service;

import ru.coffee.input.DataLoader;

public class StudentService {

    private DataLoader dataLoader;
    public StudentService(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    public String loadData() {
        return dataLoader.load();
    }
}
