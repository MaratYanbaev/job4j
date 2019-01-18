package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализовать SimpleArray<T>[#105803]
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 18.01.2019
 */
public class SimpleArray<T> implements Iterable<T> {

    private Object[] array;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Add new element
     * If array is full and try to add new element then exception
     * @param model next new element
     */
    public void add(T model) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = model;
                break;
            } else if (i == array.length - 1) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }

    /**
     *
     * @param index of value which need to replace
     * If index == or > then array's length then exception
     * @param model new element
     */
    public void set(int index, T model) {
        if (index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            array[index] = model;
        }
    }

    /**
     *
     * @param index of value which need to remove
     * If index == or > then array's length then exception
     */
    public void remove(int index) {
        if (index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int amount = array.length - ++index;
            System.arraycopy(array, index, array, --index, amount);
            array[array.length - 1] = null;
        }
    }

    /**
     *
     * @param index of value which need to get
     * If index == or > then array's length then exception
     * @return the value
     */
    public T get(int index) {
        if (index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            /**
             * Returns true if the iteration has more elements.
             * (In other words, returns true if next would
             * return an element rather than throwing an exception.)
             *
             * @return {@code true} if the iteration has more elements
             */
            @Override
            public boolean hasNext() {
                return index < array.length && array[index] != null;
            }

            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             * @throws NoSuchElementException if the iteration has no more elements
             */
            @Override
            public T next() {
                if (hasNext()) {
                    return (T) array[index++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
