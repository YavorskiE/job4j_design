package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
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
        System.arraycopy(data, index + 1, data, index, --length - index);
    }

    public T get(int index) {
        Objects.checkIndex(0, length);
        return data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < length;
            }

            @Override
            public T next() {
                return data[currentIndex++];
            }
        };
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

        for (Iterator<String> it = dataS.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }

}