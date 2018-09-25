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
public class FactorialTest {
    /**
     * Test Factorial.
     */
    @Test
    public void whenSetValueFiveThenFactorialIs120() {
        Factorial fact = new Factorial();
        fact.factorial(5);
        int expected = 120;
        assertThat(fact.result, is(expected));
    }

    @Test
    public void whenSetValueZeroThenFactorialIsOne() {
        Factorial fact = new Factorial();
        fact.factorial(0);
        int expected = 1;
        assertThat(fact.result, is(expected));
    }
}
