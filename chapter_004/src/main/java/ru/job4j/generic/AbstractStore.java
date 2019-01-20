package ru.job4j.generic;

/**
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 20.01.2019
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    private int size = 5;
    private SimpleArray<T> store = new SimpleArray<>(size);
    private int index;

    /**
     *
     * @param model - model that need to add to store
     * If store is full then catch exception and
     * raise store's capacity
     */
    @Override
    public void add(T model) {
        try {
            store.add(model);
        } catch (ArrayIndexOutOfBoundsException e) {
            SimpleArray<T> buf = new SimpleArray<>(size + 5);
            for (int i = 0; i < size; i++) {
                buf.add(store.get(i));
            }
            store = buf;
            store.add(model);
            size += 5;
        }
    }

    /**
     *
     * @param id is model's id that need to change
     * @param model - model that need to set instead of found id
     * @return if id is replaced true otherwise false
     */
    @Override
    public boolean replace(String id, T model) {
//        Первый вариант метода.
//        int index = -1;
//        for (T t : store) {
//            index++;
//            if (t.getId().equals(id)) {
//                store.remove(index);
//                return true;
//            }
//        }
        boolean result = false;
        if (this.findById(id) != null) {
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
//        Первый вариант метода.
//        int index = -1;
//        for (T t : store) {
//            index++;
//            if (t.getId().equals(id)) {
//                store.remove(index);
//                return true;
//            }
//        }
        boolean result = false;
        if (this.findById(id) != null) {
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
        index = 0;
        for (T t : store) {
            if (t.getId().equals(id)) {
                return t;
            }
            index++;
        }
        return null;
    }
}
