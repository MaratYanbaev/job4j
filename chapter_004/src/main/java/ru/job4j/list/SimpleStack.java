package ru.job4j.list;

import org.w3c.dom.Node;

/**
 * 5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack[#105791]
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 22.01.2019
 */
public class SimpleStack<T> {

    private SimpleLinkedList<T> sll = new SimpleLinkedList<>();

    /**
     * Метод вставляет в начало списка данные.
     */
    public void push(T date) {
        sll.add(date);
    }

    /**
     *
     * @return null if array empty otherwise T date
     */
        public T poll() {
            return sll.remove();
        }

}
