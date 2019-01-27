package ru.job4j.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserForMapTest {

    @Test
    public void addSomeElementToMapThenGetThem() {
        Map<UserForMap, String> map = new HashMap<>();
        UserForMap one = new UserForMap("Marat", 1);
        UserForMap two = new UserForMap("Marat", 1);
        map.put(one, "first");
        map.put(two, "second");

        System.out.println(map);
    }
}