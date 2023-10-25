package ru.coffee.input.impl;

import ru.coffee.input.DataLoader;

import java.io.*;

public class DataFromFile implements DataLoader<BufferedReader> {

    @Override
    public BufferedReader load() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("students.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return br;

    }
}
