package ru.job4j.generic;

/**
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 20.01.2019
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    private int quantity = 0; //the quantity of model in store
    private int capacity = 5; //the store's capacity
    private SimpleArray<T> store = new SimpleArray<>(capacity);

    /**
     *
     * @param model - model that need to add in store
     * If store is full (quantity == capacity) then
     * need to raise store's capacity
     */
    @Override
    public void add(T model) {
        if (capacity > quantity) {
            store.add(model);
            quantity++;
        } else {
            capacity += 5;
            SimpleArray<T> buf = new SimpleArray<>(capacity);
            for (int i = 0; i < quantity; i++) {
                buf.add(store.get(i));
            }
            store = buf;
            store.add(model);
            quantity++;
        }
    }

    /**
     *
     * @param id model's id that need to find out one's index
     * @return index if found otherwise -1
     */
    private int findIndex(String id) {
        int index = 0;
        for (T t : store) {
            if (t.getId().equals(id)) {
                break;
            }
            index++;
        }
        return index == quantity ? -1 : index;
    }

    /**
     *
     * @param id is model's id that need to change
     * @param model - model that need to map instead of found id
     * @return if id is replaced true otherwise false
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int index = this.findIndex(id);
        if (index > -1) {
            store.set(index, model);
            result = true;
        }
        return result;
    }

    /**
     *
     * @param id model's id that need to delete
     * @return if id is deleted true otherwise false
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = this.findIndex(id);
        if (index > -1) {
            store.remove(index);
            result = true;
        }
        return result;
    }

    /**
     *
     * @param id model's id that need to find
     * @return found model otherwise null
     */
    @Override
    public T findById(String id) {
        for (T t : store) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }
}
