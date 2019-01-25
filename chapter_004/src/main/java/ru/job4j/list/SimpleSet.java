package ru.job4j.list;

import java.util.Iterator;

/**
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 25.01.2019
 */
public class SimpleSet<T> implements Iterable<T> {

    private DynamicArray<T> list = new DynamicArray<>();
    private Iterator iterator;

    /**
     *
     * @param date - add to list
     */
    public void add(T date) {
        boolean result = true;
        for (T element: list) {
            if (date.equals(element)) {
                result = false;
                break;
            }
        }
        if (result) {
            list.add(date);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Iterator iterator = list.iterator();
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                return (T) iterator.next();
            }
        };
    }
}
