package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.*;

public class SimpleArrayTest {

    @Test
    public void whenAddThenGet() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("First");
        String rsl = array.get(0);
        assertThat(rsl, is("First"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("First");
        String rsl = array.iterator().next();
        assertThat(rsl, is("First"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleArray<String> array = new SimpleArray<>();
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("First");
        array.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("First");
        Iterator<String> it = array.iterator();
        array.add("Second");
        it.next();
    }

    @Test
    public void whenCap2Added5() {
        SimpleArray<String> array = new SimpleArray<>(2);
        array.add("First");
        array.add("Second");
        array.add("Third");
        array.add("Fourth");
        array.add("Fifth");
        assertThat(array.get(0), is("First"));
        assertThat(array.get(1), is("Second"));
        assertThat(array.get(2), is("Third"));
        assertThat(array.get(3), is("Fourth"));
        assertThat(array.get(4), is("Fifth"));
    }

    @Test
    public void whenCap2Added5It() {
        SimpleArray<String> array = new SimpleArray<>(2);
        String[] input = {"First", "Second", "Third", "Fourth", "Fifth"};
        String[] output = new String[input.length];
        for (String s : input) {
            array.add(s);
        }
        Iterator<String> it = array.iterator();
        for (int i = 0; it.hasNext(); i++) {
            output[i] = it.next();
        }
        assertThat(output, is(input));
    }
}