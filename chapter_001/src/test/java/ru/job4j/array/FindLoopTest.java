package ru.job4j.array;

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
public class FindLoopTest {
    /**
     * Test indexOf.
     */
    @Test
    public void whenArrayHasValue5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHas6Then3() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3, 6};
        int value = 6;
        int result = find.indexOf(input, value);
        int expect = 3;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasValue4ThenMinus1() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 4;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
