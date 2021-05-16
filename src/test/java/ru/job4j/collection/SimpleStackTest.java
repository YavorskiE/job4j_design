package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class SimpleStackTest {

    @Test
    public void whenPushThenPoll() {
        SimpleStack<Integer> stack  = new SimpleStack<>();
        stack.push(1);
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void whenPushPollThenPushPoll() {
        SimpleStack<Integer> stack  = new SimpleStack<>();
        stack.push(1);
        stack.pop();
        stack.push(2);
        assertThat(stack.pop(), is(2));
    }

    @Test
    public void whenPushPushThenPollPoll() {
        SimpleStack<Integer> stack  = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void whenEmpty() {
        SimpleStack<Integer> stack  = new SimpleStack<>();
        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void whenIsNotEmpty() {
        SimpleStack<Integer> stack  = new SimpleStack<>();
        stack.push(1);
        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void whenEmptied() {
        SimpleStack<Integer> stack  = new SimpleStack<>();
        stack.push(1);
        stack.pop();
        assertThat(stack.isEmpty(), is(true));
    }
}
