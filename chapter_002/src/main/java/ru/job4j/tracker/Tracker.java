package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

/**
 * @version &Id&
 * @since 0.1
 */
public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();

    /**
     * Метод реализующий добавление новой заявки в хранилище.
     * @param item новая заявка.
     */
    public void add(Item item) {
        items.add(item);
    }

    /**
     *
     * @param name which need to find in array item.
     * @return array with item which contain this.name.
     */
    public ArrayList<Item> findByName(String name) {
        return items.stream().filter(t -> name.equals(t.getName())).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * set
     * @param id that needs to find among array.
     * @return necessary object to required id.
     */
    public Item findById(String id) {
        /*Item result = null;
        if (id.length() == 13) {
            for (Item item: items) {
                if (id.equals(item.getId())) {
                    result = item;
                }
            }
        }*/
        return items.stream().filter(t -> id.equals(t.getId())).reduce((t, item1) -> item1 = t).orElse(null);
    }

    /**
     *
     * @return array of items without null element.
     */
    public ArrayList<Item> getItems() {
        return this.items;
    }

    /**
     *
     * @param id element that necessary to replace
     * @param next element that necessary to place instead of element to Id
     */
    public void replace(String id, Item next) {
        int i = (items.indexOf(this.findById(id)));
        if (i != -1) {
            items.remove(i);
            items.add(i, next);
        }
    }

    /**
     *
     * @param id element to this id that need to delete.
     */
    public boolean delete(String id) {
        boolean exist = true;
        Item item = this.findById(id);
        if ((item == null)) {
            exist = false;
        } else {
            items.remove(items.indexOf(item));
        }
        return exist;
    }
}
