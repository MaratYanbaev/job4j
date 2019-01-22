package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 22.01.2019
 */
public class SimpleLinkedList<T> implements Iterable<T> {

    private SimpleLinkedList.Node<T> first;
    private int size;

    /**
     * The number of list's modification
     */
    private int modCount;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(T date) {
        modCount++;
        SimpleLinkedList.Node<T> newLink = new SimpleLinkedList.Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public T get(int index) {
        SimpleLinkedList.Node<T> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {

        E date;
        SimpleLinkedList.Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor = 0; // index of next element to return
            private int expectedModCount = modCount;
            SimpleLinkedList.Node<T> buf;

            /**
             * @return true if the iteration has more elements
             */
            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            /**
             *
             * @return the next element in the iteration
             * @throws NoSuchElementException if the iteration has no more elements
             */
            @Override
            public T next() {
                checkModification();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (cursor < 1) {
                    buf = first;
                } else {
                    buf = buf.next;
                }
                cursor++;
                return (T) buf.date;
            }

            /**
             * @throws ConcurrentModificationException if modCount not equal expectedModCount
             */
            final void checkModification() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
