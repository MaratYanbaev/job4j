package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор для двухмерного массива.
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 15.01.2019
 */
public class MatrixIterator implements Iterator {

    private final int[][] it;
    private int row = 0;
    private int index = 0;

    public MatrixIterator(final int[][] it) {
        this.it = it;
    }

    /**
     *
     * @return true if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return row != it.length;
    }

    /**
     *
     * @return the next element in the iteration
     */
    @Override
    public Object next() {
        Object result = null;
        if (row == it.length) {
            throw new NoSuchElementException();
        }
        result = it[row][index];
        if (index == it[row].length - 1) {
            row++;
            index = 0;
        } else {
            index++;
        }
        return result;
    }
}
