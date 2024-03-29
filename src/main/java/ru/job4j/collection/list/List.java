package ru.job4j.collection.list;

import java.util.Iterator;

public interface List<E> extends Iterable<E> {
    void add(E value);
    E get(int index);
    Iterator<E> iterator();
}
