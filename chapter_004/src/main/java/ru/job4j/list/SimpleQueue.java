package ru.job4j.list;

/**
 *
 * 5.3.3.1 Очередь на двух стеках[#105794]
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 22.01.2019
 */
public class SimpleQueue<T> {

    private SimpleStack<T> sllOne = new SimpleStack<>();
    private SimpleStack<T> sllTwo = new SimpleStack<>();
    private int size;
    private int cursor;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void push(T date) {
        this.size++;
        sllOne.push(date);
    }

    /**
     *
     * @return null if array empty otherwise T date
     */
    public T poll() {
        if (cursor == 0 && size > 0) {
            for (int i = 0; i < size; i++) {
                sllTwo.push(sllOne.poll());
            }
            cursor = size;
            size = 0;
        }
        cursor--;
        return sllTwo.poll();
    }
}
