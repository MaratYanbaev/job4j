package ru.job4j.generic;

import java.util.Random;

/**
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 19.01.2019
 */
public class Role extends Base {

    private final String role;

    /**
     *
     * @param role of Role
     */
    protected Role(String role) {
        super(String.valueOf(new Random().nextInt() + System.currentTimeMillis()));
        this.role = role;
    }

    /**
     *
     * @return this role
     */
    public String getRole() {
        return role;
    }
}
