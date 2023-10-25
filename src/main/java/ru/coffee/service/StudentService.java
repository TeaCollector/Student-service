package ru.coffee.service;

import ru.coffee.input.DataLoader;

import java.io.BufferedReader;

public class StudentService {

    private DataLoader<BufferedReader> dataLoader;
    public StudentService(DataLoader<BufferedReader> dataLoader) {
        this.dataLoader = dataLoader;
    }

    public BufferedReader loadData() {
        return dataLoader.load();
    }
}
