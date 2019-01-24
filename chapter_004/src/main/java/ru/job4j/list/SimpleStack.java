package ru.job4j.list;

import org.w3c.dom.Node;

/**
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 22.01.2019
 */
public class SimpleStack<T> {

    private SimpleLinkedList<T> sll = new SimpleLinkedList<>();
    private int size;
    private int cursor;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void push(T date) {
        this.size++;
        sll.add(date);
    }

    /**
     *
     * @return null if array empty otherwise T date
     */
    public T poll() {
        return size > cursor ? sll.get(cursor++) : null;
    }
}
