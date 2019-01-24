package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SimpleQueueTest {

    private SimpleQueue<Integer> sq;

    @Before
    public void setUp() {
        sq = new SimpleQueue<>();
        sq.push(1);
        sq.push(2);
        sq.push(3);
    }

    @Test
    public void pollAllElementThenOrderMustBeFIFO() {
        assertThat(sq.poll(), is(1));
        assertThat(sq.poll(), is(2));
        assertThat(sq.poll(), is(3));
    }

    @Test
    public void queueMustPollTheFirstElementsWhenPushExtraAfterFirstPoll() {
        assertThat(sq.poll(), is(1));
        sq.push(4);
        sq.push(5);
        sq.push(6);
        assertThat(sq.poll(), is(2));
        assertThat(sq.poll(), is(3));
        assertThat(sq.poll(), is(4));
        assertThat(sq.poll(), is(5));
        assertThat(sq.poll(), is(6));
        assertThat(sq.poll(), is(nullValue()));
    }

}