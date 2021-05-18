package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void addFirst(T value) {
        head = new Node<>(value, head);
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T value = head.value;
        head = head.next;
        return value;
    }

    public boolean revert() {
        if (head == null || head.next == null) {
            return false;
        }
        Node<T> nextNode;
        Node<T> node = head.next;
        head.next = null;
        Node<T> prevNode = head;
        while (node != null) {
            nextNode  = node.next;
            node.next  = prevNode;
            prevNode = node;
            node = nextNode;
        }
        head = prevNode;
        return true;
    }

    public boolean revert1() {
        if (head == null || head.next == null) {
            return false;
        }
        ForwardLinked<T> newLink = new ForwardLinked<>();
        while (head != null) {
            newLink.addFirst(this.deleteFirst());
        }
        head = newLink.head;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
               T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
