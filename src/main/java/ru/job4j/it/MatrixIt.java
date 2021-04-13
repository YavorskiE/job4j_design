package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {

    private final int[][] data;
    private int row =  0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length && data[row].length == 0) {
            row++;
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int next = data[row][column++];
        if (column == data[row].length) {
            column = 0;
            row++;
        }
        return next;
    }

    public static void main(String[] args) {
        int[][] in = {
                {1, 2},
                {3, 4}
        };
        MatrixIt it = new MatrixIt(in);
        while (it.hasNext()) {
            System.out.print(it.next() + "   ");
        }
    }
}
