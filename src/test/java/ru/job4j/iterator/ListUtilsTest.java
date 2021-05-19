package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterWithLastIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.addAfter(input, 2, 4);
        assertThat(Arrays.asList(1, 2, 3, 4), Is.is(input));
    }

    @Test
    public void whenAddThenRemove() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ListUtils.removeIf(input, (e -> e < 3));
        assertThat(input, Is.is(Arrays.asList(3, 4)));
    }

    @Test
    public void whenNothingToRemove() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ListUtils.removeIf(input, (e -> e > 4));
        assertThat(input, Is.is(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    public void whenAddThenReplace() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ListUtils.replaceIf(input, (e -> e < 3), 5);
        assertThat(input, Is.is(Arrays.asList(5, 5, 3, 4)));
    }

    @Test
    public void whenRemoveList() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> toRemove = new ArrayList<>(Arrays.asList(2, 4));
        ListUtils.removeAll(input, toRemove);
        assertThat(input, Is.is(Arrays.asList(1, 3, 5)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> toRemove = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ListUtils.removeAll(input, toRemove);
        assertThat(input, Is.is(Collections.emptyList()));
    }
}