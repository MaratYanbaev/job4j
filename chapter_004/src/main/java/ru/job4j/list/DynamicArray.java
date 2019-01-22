package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 21.01.2019
 */
public class DynamicArray<T> implements Iterable<T> {

    private Object[] array = new Object[10];

    /**
     * The number of array's modification
     */
    private int modCount;

    /**
     * The number of elements in array
     */
    private int quantity = 0;

    private void grow() {
        Object[] buf = new Object[quantity + 10];
        for (int i = 0; i < quantity; i++) {
            buf[i] = array[i];
        }
        array = buf;
    }

    /**
     * Grow new bigger array if quantity < array.length
     * Add new element
     * @param model - next new element
     */
    public void add(T model) {
        modCount++;
        if (quantity >= array.length) {
            grow();
            array[quantity++] = model;
        } else {
            array[quantity++] = model;
        }
    }

    /**
     * ArrayIndexOutOfBoundsException if getting index >= array.length
     * @param index of value which need to get
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
            int cursor = 0; // index of next element to return
            private int expectedModCount = modCount;

            /**
             * Returns true if the iteration has more elements
             * @return true if the iteration has more elements
             */
            @Override
            public boolean hasNext() {
                return cursor < quantity;
            }

            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             * @throws NoSuchElementException if the iteration has no more elements
             */
            @Override
            public T next() {
                checkModification();
                if (hasNext()) {
                    return (T) array[cursor++];
                } else {
                    throw new NoSuchElementException();
                }
            }

            final void checkModification() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
