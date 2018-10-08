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
    public void whenSortArrayWithTenElementsThenGetSortedArray() {
        BubbleSort sortArray = new BubbleSort();
        int[] array = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        sortArray.arraySort(array);
        int[] model = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(model, is(array));
    }
}
