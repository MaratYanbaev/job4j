package ru.job4j.generic;

import java.util.Random;

/**
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 19.01.2019
 */
public class User extends Base {

    private final String name;

    /**
     *
     * @param name of User
     */
    protected User(String name) {
        super(String.valueOf(new Random().nextInt() + System.currentTimeMillis()));
        this.name = name;
    }

    /**
     *
     * @return this name
     */
    public String getName() {
        return name;
    }
}
