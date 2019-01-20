package ru.job4j.generic;

/**
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 19.01.2019
 */
public abstract class Base {

    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
