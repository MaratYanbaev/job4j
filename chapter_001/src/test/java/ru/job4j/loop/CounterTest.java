package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CounterTest {
    /**
     * Test Counter.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
        counter.evenNumber(1, 10);
        int expected = 30;
        assertThat(counter.result, is(expected));
    }

    @Test
    public void whenStartMoreThanFinish() {
        Counter counter = new Counter();
        counter.evenNumber(12, 10);
        int expected = 0;
        assertThat(counter.result, is(expected));
    }

    @Test
    public void whenStartIdenticalFinish() {
        Counter counter = new Counter();
        counter.evenNumber(12, 12);
        int expected = 12;
        assertThat(counter.result, is(expected));
    }
}