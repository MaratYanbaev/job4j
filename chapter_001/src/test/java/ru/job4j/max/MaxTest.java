package ru.job4j.max;

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

public class MaxTest {
    /**
     * Test Max
     */

    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstMoreSecond() {
        Max maximum = new Max();
        int result = maximum.max(5, 3);
        assertThat(result, is(5));
    }

    @Test
    public void whenFirstMoreThenSecondAndThird() {
        Max maximum = new Max();
        int result = maximum.max(10, 8, 5);
        assertThat(result, is(10));
    }

    @Test
    public void whenSecondMoreThenFirstAndThird() {
        Max maximum = new Max();
        int result = maximum.max(4, 9, 5);
        assertThat(result, is(9));
    }

    @Test
    public void whenThirdMoreThenSecondAndFirst() {
        Max maximum = new Max();
        int result = maximum.max(1, 4, 5);
        assertThat(result, is(5));
    }
}
