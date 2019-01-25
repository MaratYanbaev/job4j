package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void addElementsAndOneTheSameThenGetWithoutDuplicate() {
        SimpleSet<String> str = new SimpleSet<>();
        str.add("One");
        str.add("Two");
        str.add("Free");
        str.add("Four");
        str.add("Five");
        str.add("One");
        Iterator iterator = str.iterator();

        assertThat(iterator.next(), is("One"));
        assertThat(iterator.next(), is("Two"));
        assertThat(iterator.next(), is("Free"));
        assertThat(iterator.next(), is("Four"));
        assertThat(iterator.next(), is("Five"));
        assertThat(iterator.hasNext(), is(false));
    }

}