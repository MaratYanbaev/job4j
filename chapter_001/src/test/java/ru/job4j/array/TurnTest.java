package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TurnTest {
    /**
     *  Test turn.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {4, 1, 2, 3};
        int[] result = turner.turn(input);
        int[] expect = new int[] {3, 2, 1, 4};
        assertThat(result, is(expect));
    }
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {4, 1, 6, 2, 3};
        int[] result = turner.turn(input);
        int[] expect = new int[] {3, 2, 6, 1, 4};
        assertThat(result, is(expect));
    }
}
