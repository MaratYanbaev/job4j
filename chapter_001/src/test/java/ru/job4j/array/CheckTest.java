package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CheckTest {
    /**
     * Test mono.
     */
    @Test
    public void whenDataNotMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}
