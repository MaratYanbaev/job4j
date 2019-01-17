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
     * @return amount of steps to next even number
     */
    private int searchNext() {
        int result = -1;
        for (int i = index; i < values.length; i++) {
            result ++;
            if (values[i] % 2 == 0) {
                break;
            }
        }
        return result;
    }

    /**
     *
     * @return true if has next even number otherwise false.
     */
    @Override
    public boolean hasNext() {
        return values[index + searchNext()] % 2 == 0;
    }

    /**
     *
     * @return next even number
     * @throws NoSuchElementException - if the iteration has no more elements
     */
    @Override
    public Object next() {
        index += searchNext();
        if (index < values.length && values[index] % 2 != 0) {
            throw new NoSuchElementException();
        } else {
            return values[index++];
        }
    }
}
