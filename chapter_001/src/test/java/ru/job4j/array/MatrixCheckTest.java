package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test MatrixCheck
 *
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @version &Id&
 * @since 0.1
 */
public class MatrixCheckTest {
    @Test
    public void whenDataOddMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataOddNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataEvenMonoByTrueThenTrue() {
        //noinspection unused
        MatrixCheck check = new MatrixCheck();
        //noinspection unused
        boolean[][] input = new boolean[][] {
                {true, true, false, true},
                {false, true, true, false},
                {false, true, true, true},
                {true, true, false, true}
        };
    }

    @Test
    public void whenDataEvenNotMonoByTrueThenTrue() {
        //noinspection unused
        MatrixCheck check = new MatrixCheck();
        //noinspection unused
        boolean[][] input = new boolean[][] {
                {true, true, false, false},
                {true, false, true, false},
                {false, true, true, true},
                {true, true, false, true}
        };
    }
}
