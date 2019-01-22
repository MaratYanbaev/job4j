package ru.job4j.list;

/**
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 22.01.2019
 */
public class SimpleStack<E> {

    private int size;
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void push(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     *
     * @return null if it doesn't has any element otherwise E date
     */
    public E poll() {
        Node<E> result = new Node<>(null);
        if (first != null) {
            result = first;
            first = first.next;
            size--;
        }
        return result.date;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {

        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }
}
