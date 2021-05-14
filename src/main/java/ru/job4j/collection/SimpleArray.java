package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private int capacity;
    private Object[] container;
    private int size = 0;
    private long modCount = 0;

    public SimpleArray() {
        capacity = 16;
        container = new Object[capacity];
    }

    public SimpleArray(int capacity) {
        this.capacity = capacity;
        container = new Object[capacity];
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    public void add(T model) {
        if (size == capacity) {
            capacity *= 2;
            Object[] newContainer =  new Object[capacity];
            System.arraycopy(container, 0, newContainer, 0, size);
            container = newContainer;
        }
        container[size++] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;
            private final long expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[index++];
            }
        };
    }
}
