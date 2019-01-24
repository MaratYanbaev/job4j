package ru.job4j.list;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {

    private SimpleStack<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleStack<>();
        list.push(1);
        list.push(2);
        list.push(3);
    }

    @Test
    public void whenPollThreeTimesThenLIFOResult() {
        assertThat(list.poll(), is(3));
        assertThat(list.poll(), is(2));
        assertThat(list.poll(), is(1));
    }

    @Test
    public void whenPollThreeTimesThenFourthNull() {
        list.poll();
        list.poll();
        list.poll();

        assertThat(list.poll(), is(nullValue()));


        list.push(4);
        list.push(5);
        list.push(6);


        assertThat(list.poll(), is(6));
        assertThat(list.poll(), is(5));
        assertThat(list.poll(), is(4));
    }
}