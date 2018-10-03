package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Test
 *
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @version &Id&
 * @since  0.1
 */
public class ArrayDuplicateTest {
    /**
     * Test remove.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate dup = new ArrayDuplicate();
        String[] result =
                dup.remove(new String[]{"Привет", "Привет", "Мир", "Привет", "Супер", "Мир", "Привет", "Мир"});
        String[] expect = {"Привет", "Мир", "Супер"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}
