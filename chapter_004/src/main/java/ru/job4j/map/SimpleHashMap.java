package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 8. Реализовать собственную структуру данных - HashMap[#105818]
 *
 * Ассоциативный массив на базе хэш-таблицы должен быть унифицирован через генерики и иметь методы:
 * boolean insert(K key, V value);
 * V get(K key);
 * boolean delete(K key);
 *
 * Реализовывать итератор.
 * Внутренняя реализация должна использовать массив. Нужно обеспечить фиксированное время вставки и получение. Предусмотрите возможность роста хэш-таблицы при нехватке места для нового элемента.
 *
 * Методы разрешения коллизий реализовывать не надо. Например: если при добавлении ключ уже есть, то возвращать false.
 *
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 29.01.2019
 */
public class SimpleHashMap<K, V> {

    private Node<K, V>[] table;
    static final int DEFAULT_CAPACITY = 8;
    static final float LOAD_FACTOR = 0.75f;
    /**
     * Максимальное колличество элементов в массиве,
     * при привышении этого значения, массив увеливается.
     */
    private int threshold;
    private int modCount;
    /**
     * Колличество элементов в массиве.
     */
    private int quantity;


    public SimpleHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        threshold = (int) (table.length * LOAD_FACTOR);
    }

    /**
     * Метод ввода новых элементов в таблицу
     * @param key - параметр ключ
     * @param value - параметр значение
     * @return - False, если имеется идентичный элемент иначе true
     */
    public boolean insert(K key, V value) {
        int hash = hash(key);
        int index = hash % (table.length - 1);
        if (quantity >= threshold) {
            table = resize();
            index = hash % (table.length - 1);
        } else if ((table[index]) != null) {
            return false;
        }
            table[index] = new Node<>(key, value, hash);
            quantity++;
            modCount++;
        return true;
    }

    /**
     * Метод увелечения массива в два раза при его переполнении на 75%
     * Если мы вычислили индекс в новом массиве для объекта взятого
     * из старого массива и индекс в новом массиве уже занят,
     * тогда объект не записывается из старого массива
     * в новый массив и отбрасывается.
     *
     * @return - увеличенный массив со всеми элементами если небыло коллизий
     */
    private Node<K, V>[] resize() {
        int index;
        threshold = threshold << 1;
        Node<K, V>[] newTab = new Node[table.length << 1];
        Node<K, V>[] oldTab = table;
        for (Node old: oldTab) {
            if (old != null) {
                index = old.hash % (newTab.length - 1);
                if (newTab[index] == null && old.key != null) {
                    newTab[index] = old;
                }
            }
        }
        return newTab;
    }

    /**
     * Метод для вычисления хэшкода
     * @param key - ключ для которого высчитывается хэшкод
     * @return - хэшкод
     */
    private int hash(K key) {
        int h = key.hashCode();
        return (h) ^ (h >>> 16);
    }

    /**
     * Метод получения значения V по ключу
     * @param key - ключ по которому необходимо найти значение
     * @return - значение, если идентичного клюса не найдено тогда null
     */
    public V get(K key) {
        V result = null;
        int index = this.getIndex(key);
        if (index >= 0) {
                result = table[index].getValue();
            }
        return result;
    }

    /**
     * Метод удаления элемента из массива по ключу
     * @param key - ключ по которому необходимо найти значение и удалить
     * @return - true, если идентичного клюса не найдено тогда false
     */
    public boolean delete(K key) {
        boolean result = false;
        int index = this.getIndex(key);
            if (index >= 0) {
                table[index] = null;
                quantity--;
                modCount++;
                result = true;
        }
        return result;
    }

    /**
     * Метод поиска индекса по ключу
     * @param key - ключ для которого необходимо найти индекс
     * @return - индекс, если в этой ячейке имеется идентичный ключ тогда -1
     */
    private int getIndex(K key) {
        int p, h;
        int result = -1;
        K k;
        h = hash(key);
        int index = h % (table.length - 1);
        Node<K, V> node = table[index];
        if (node != null) {
            p = node.getHash();
            k = node.getKey();
            if ((h == p) && (key.equals(k))) {
                result = index;
            }
        }
        return result;
    }

    /**
     * @return - колличество элементов в таблице
     */
    public int getQuantity() {
        return quantity;
    }

    static class Node<K, V> {

        private final K key;
        private V value;
        private final int hash;


        public Node(K key, V value, int hash) {
            this.value = value;
            this.key = key;
            this.hash = hash;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }

        public int getHash() {
            return hash;
        }

    }

    public Iterator iterator() {
        return new Iterator<>() {

            int cursor = 0;
            int capacity = table.length;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                while ((cursor < capacity) && (table[cursor] == null)) {
                    cursor++;
                }
                return cursor < capacity;
            }

            @Override
            public Node<K, V> next() {
                checkModification();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    return table[cursor++];
                }
            }

            private void checkModification() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
