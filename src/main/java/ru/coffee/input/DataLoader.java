package ru.coffee.input;


import java.io.BufferedReader;

public interface DataLoader<T> {
    T load();
}
