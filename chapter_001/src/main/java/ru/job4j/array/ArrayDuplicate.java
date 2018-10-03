package ru.job4j.array;

import java.util.Arrays;

/**
 * Class ArrayDuplicate 6.8. Удаление дубликатов в массиве. [#225]
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 2.10.2018
 */
public class ArrayDuplicate {

    /**
     * Удаляем дубликаты.
     * @param array - массив для очистки.
     * @return - массив без дубликатов.
     */
    public String[] remove(String[] array) {
        int length = array.length;
        for (int outer = 0; outer < length; outer++) {
            for (int inner = outer + 1; inner < length; inner++) {
                if (array[outer].equals(array[inner])) {
                    array[inner] = array[length - 1];
                    length--;
                    inner--;
                }
            }
        }
        return Arrays.copyOf(array, length);
    }
}
