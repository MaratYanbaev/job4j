package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test BubbleSort.
 *
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @version &Id&
 * @since 0.1
 */
public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubble = new BubbleSort();
        int res[] = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        bubble.bubbleSort (res);
        int result[] = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, is(res));
    }
}
