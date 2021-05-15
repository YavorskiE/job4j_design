package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;
    private long modCount = 0;

    @Override
    public void add(E value) {
        final Node<E> tmpNode = last;
        final Node<E> newNode = new Node<>(value, tmpNode, null);
        last = newNode;
        if (tmpNode == null) {
            first = newNode;
        } else {
            tmpNode.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> tmpNode = first;
        for (int i = 0; i < index; i++) {
            tmpNode = tmpNode.next;
        }
        return tmpNode.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private final long expectedModCount = modCount;
            private Node<E> thisNode = first;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return  thisNode != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> tmpNode = thisNode;
                thisNode = thisNode.next;
                return tmpNode.item;
            }
        };
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(E element, Node<E> prev, Node<E> next) {
            item = element;
            this.prev = prev;
            this.next = next;
        }
    }
}
