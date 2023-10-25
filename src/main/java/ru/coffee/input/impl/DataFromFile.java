package ru.coffee.input.impl;

import ru.coffee.input.DataLoader;

import java.io.*;

public class DataFromFile implements DataLoader {
    @Override
    public String load() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("students.csv"));
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
