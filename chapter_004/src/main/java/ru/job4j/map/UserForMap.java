package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;
import java.util.Random;

/**
 * 1. Создать модель User[#105811]
 *
 * Создать модель User и три поля
 * String name,
 * int children,
 * Calendar birthday,
 *
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 25.01.2019
 */
public class UserForMap {
    private String name;
    private int children;
    private Calendar birthday;


    public UserForMap(String name, int children) {
        this.name = name;
        this.children = children;
    }

    @Override
    public int hashCode() {
        int result = 11;
        result = result * 31 + name.hashCode();
        result = result * 31 + children;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserForMap user = (UserForMap) o;
        return children == user.children
                && Objects.equals(name, user.name);
    }
}
