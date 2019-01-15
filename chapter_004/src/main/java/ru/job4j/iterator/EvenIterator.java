package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор возвращающий только четные цифры.
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 15.01.2019
 */
public class EvenIterator implements Iterator {
    private final int[] values;
    private int index = 0;

    public EvenIterator(final int[] values) {
        this.values = values;
    }

    /**
     *
     * @return true if has next even number otherwise false.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     *
     * @return next even number
     * @throws NoSuchElementException - if the iteration has no more elements
     */
    @Override
    public Object next() {
        int next = 0;
        for (int i = index; i < values.length; i++) {
            index++;
            if (values[i] % 2 == 0) {
                next = values[i];
                break;
            } else if (index == values.length) {
                throw new NoSuchElementException();
            }
        }
        return next;
    }
}
