package ru.coffee.input.impl;

import ru.coffee.input.DataLoader;

import java.io.*;

public class DataFromFile implements DataLoader<BufferedReader> {

    private String pathToFile;

    public DataFromFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public BufferedReader load() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(pathToFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return br;

    }
}
