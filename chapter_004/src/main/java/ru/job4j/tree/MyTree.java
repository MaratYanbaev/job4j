package ru.job4j.tree;

import java.util.*;

/**
 * 1. Создать элементарную структуру дерева[#105824]
 * метод add - Должен находить элемент parent в дереве и добавлять в него дочерний элемент.
 * node.children.add(child);
 * Для поиска элементов в дереве надо использовать методы findBy - Он уже реализован.
 * В дереве не могут быть дубликатов, т.е. никакие узлы в дереве не должны иметь двух одинаковых дочерних узлов.
 * Обязательно реализуйте итератор.
 *
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 02.02.2019
 */
public class MyTree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    public MyTree(E i) {
        root = new Node<>(i);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = this.findBy(child).isEmpty();
        if (result) {
            Optional<Node<E>> optional = this.findBy(parent);
            result = optional.isPresent();
            if (result) {
                optional.get().add(new Node<>(child));
            }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.branch()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {

        Queue<Node<E>> queue = new LinkedList<>();
        ArrayList<E> list = new ArrayList<>();
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            Node<E> el = queue.poll();
            list.add(el.getValue());
            for (Node<E> child : el.branch()) {
                queue.offer(child);
            }
        }

        return list.iterator();

//        return new Iterator<E>() {
//
//            @Override
//            public boolean hasNext() {
//                return iterator.hasNext();
//            }
//
//            @Override
//            public E next() {
//                if (!(hasNext())) {
//                    throw new NoSuchElementException();
//                }
//                return iterator.next();
//            }
//        };
    }
}

