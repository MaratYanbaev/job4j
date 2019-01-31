package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class SimpleHashMapTest {

    private SimpleHashMap<UserForMap, String> shm;

    private UserForMap one;
    private UserForMap two;
    private UserForMap three;
    private UserForMap four;
    private UserForMap five;
    private UserForMap six;

    private Iterator it;

    @Before
    public void setUp() {
        shm = new SimpleHashMap<>();
        one = new UserForMap("Marat", 1);
        two = new UserForMap("Dima", 0);
        three = new UserForMap("Sergei", 4);
        four = new UserForMap("Zheny", 2);
        five = new UserForMap("Oleg", 1);
        six = new UserForMap("Sveta", 3);

        shm.insert(one, "First");
        shm.insert(two, "Second");
        shm.insert(three, "Third");
        shm.insert(four, "Fourth");
        shm.insert(five, "Fifth");
        shm.insert(six, "Sixth");

        it = shm.iterator();
    }

    @Test
    public void tryGetSomeElementHashMapThenGetValue() {
        UserForMap usm = new UserForMap("Marat", 1);

        assertThat(shm.get(usm), is("First"));
    }

    @Test
    public void tryGetSomeElementHashMapThenReturnNull() {
        UserForMap usm = new UserForMap("Marat", 2);

        assertThat(shm.get(usm), is(nullValue()));
    }

    @Test
    public void checkResizeMethodTryAddThreeElement() {
        shm.insert(new UserForMap("Elizaveta", 1), "Seventh");
        shm.insert(new UserForMap("Oly", 4), "Eighth");
        shm.insert(new UserForMap("Aleksandr", 0), "Ninth");
    }

    @Test
    public void deleteSomeElementThenTryGetOne() {
        shm.delete(one);

        assertThat(shm.get(one), is(nullValue()));
    }

    @Test
    public void tryDeleteNotExistElementThenFalse() {
        boolean result = shm.delete(new UserForMap("Elizaveta", 1));

        assertThat(result, is(false));
    }

    @Test
    public void getNextNotNullElement() {
        /**
         * steps = колличество шагов чтобы
         *            получить все not null элементы
         */
        int steps = shm.getQuantity();

        for (int i = steps; i > 0; i--) {
            assertThat(it.next(), is(notNullValue()));
        }
        assertThat(it.hasNext(), is(false));
    }
}