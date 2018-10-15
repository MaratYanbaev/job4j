package ru.job4j.tracker;

import java.util.Random;
import static java.util.Arrays.*;

/**
 * @version &Id&
 * @since 0.1
 */
public class Tracker {
    private static final Random RN = new Random();
    private final Item[] items = new Item[100];
    private int position = 0;

    /**
     * Метод реализующий добавление новой заявки в хранилище.
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод генерирует уникальный ключ заявки.
     * @return уникальный ключ
     */
    private String generateId() {
        return (String.valueOf(RN.nextInt() + System.currentTimeMillis()));
    }

    /**
     * @param name which need to find in array item.
     * @return array with item which contain this.name.
     */
    public Item[] findByName(String name) {
        int l = 0;
        Item[] result = new Item[position - 1];
        for (int index = 0; index < position; index++) {
            if (name.equals(items[index].getName())) {
                result[l] = items[index];
                l++;
            }
        }
        return copyOf(result, l);
    }

    /**
     * @param id that needs to find among array.
     * @return necessary object to required id.
     */
    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index < position; index++) {
            if (id.equals(items[index].getId())) {
                result = items[index];
            }
        }
        return result;
    }

    /**
     * @return array without null element.
     */
    public Item[] findAll() {
        Item[] result = new Item[position];
        for (int index = 0; index < position; index++) {
            result[index] = items[index];
        }
        return result;
    }

    /**
     * @param id element that necessary to replace
     * @param next element that necessary to place instead of element to Id
     */
    public void replace(String id, Item next) {
        items[asList(items).indexOf(this.findById(id))] = next;

    }

    /**
     * @param id element to this id that need to delete.
     */
    public void delete(String id) {
        int index = asList(items).indexOf(this.findById(id));
        System.arraycopy(
                items, index + 1, items, index, position - index
        );
        position--;
    }
}
