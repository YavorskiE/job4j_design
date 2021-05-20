package ru.job4j.collection.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddString() {
        Set<String> set = new SimpleSet<>();
        assertTrue(set.add("First"));
        assertTrue(set.contains("First"));
        assertFalse(set.add("First"));
    }

    @Test
    public void whenEmpty() {
        Set<String> set = new SimpleSet<>();
        assertFalse(set.contains("First"));
        assertFalse(set.contains(null));
    }

    @Test
    public void whenAddThenIt() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(1);
        Iterator<Integer> it = set.iterator();
        assertTrue(it.hasNext());
        assertThat(it.next(), is(1));
        assertFalse(it.hasNext());
    }

    @Test
    public void whenEmptyThenIt() {
        Set<Integer> set = new SimpleSet<>();
        assertFalse(set.iterator().hasNext());
    }
}