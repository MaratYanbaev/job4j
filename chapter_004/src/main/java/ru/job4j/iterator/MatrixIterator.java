package ru.job4j.iterator;

import java.util.Iterator;

public class MatrixIterator implements Iterator {

private final int[][] it;
private int size;
private int next;
private int row = 0;
private int index = 0;

    public MatrixIterator(final int[][] it) {
        this.it = it;
        for (int i = 0; i < it.length; i++) {
            this.size += it[i].length;
        }
    }

    @Override
    public boolean hasNext() {
        return size > next;
    }

    @Override
    public Object next() {
        if (index == it[row].length) {
            row++;
            index = 0;
        }
        next++;
        return it[row][index++];
    }
}
