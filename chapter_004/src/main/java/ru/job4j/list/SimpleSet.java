package ru.job4j.list;

import java.util.Iterator;

/**
 * 1. Реализовать коллекцию Set на массиве[#105808]
 *
 * Реализовать коллекцию SimpleSet. Коллекция должна обеспечивать void add(E e)
 * и реализовывать Iterable<E>.
 * Коллекция не должна хранить дубликаты.
 * Set - внутри для хранения данных использует обычные массивы.
 *
 * Код будет идентичным, как и в SimpleList(Это код из задания реализации списка на массиве).
 * как можно за счет композиции сократить количества кода?
 * Здесь нужно использовать SimpleList в реализации SimpleSet.
 *
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
