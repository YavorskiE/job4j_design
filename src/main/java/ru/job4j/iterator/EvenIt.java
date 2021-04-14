package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {

    private final int[] numbers;
    private int count = 0;

    public EvenIt(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        while (count < numbers.length) {
            if (numbers[count] % 2 == 0) {
                return true;
            }
            count++;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[count++];
    }

    public static void main(String[] args) {
        Iterator<Integer> it = new EvenIt(new int[] {4, 2, 1, 1});
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
