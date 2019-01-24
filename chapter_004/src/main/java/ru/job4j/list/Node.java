package ru.job4j.list;

/**
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 24.01.2019
 */
public class Node<E> {

    E value;
    Node<E> next;

    public Node(E value) {
        this.value = value;
    }
}