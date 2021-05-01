package ru.job4j.generics;

import java.util.Objects;

public class SimpleArray<T> {
    private final T[] data;
    private int length = 0;

    public SimpleArray(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Array length < 0");
        }
        data = (T[]) new Object[size];
    }

    public void add(T model) {
        data[length++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(0, length);
        data[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(0, length);
        System.arraycopy(data, index + 1, data, index, length - index - 1);
    }

    public T get(int index) {
        Objects.checkIndex(0, length);
        return data[index];
    }

    public static void main(String[] args) {

        SimpleArray<Integer> dataI = new SimpleArray<>(10);
        for (int i = 1; i < 6; i++) {
            dataI.add(i);
        }

        SimpleArray<String> dataS = new SimpleArray<>(10);
        dataS.add("First");
        dataS.add("Second");
        dataS.add("Second");
        dataS.add("3");
        dataS.add("Fourth");
        dataS.add("Fifth");
        dataS.remove(2);
        dataS.set(2, "Third");

        for (int i = 0; i < 5; i++) {
            System.out.println(dataI.get(i) + " -> " + dataS.get(i));
        }
    }

}
