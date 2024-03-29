package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardArrayIt implements Iterator<Integer> {

    private final int[] data;
    private int count = 0;

    public BackwardArrayIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return count < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[data.length - ++count];
    }
}
