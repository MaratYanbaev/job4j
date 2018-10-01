package ru.job4j.array;

/**
 * Class Matrix 6.6. Двухмерный массив. Таблица умножения. [#33491]
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 01.10.2018
 */
public class Matrix {

    /**
     * Таблица умножения.
     * @param size - размер таблицы.
     * @return - готовую таблицу.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int one = 0; one < size; one++) {
            for (int two = 0; two < size; two++) {
                table[one][two] = (one + 1) * (two + 1);
            }
        }
        return table;
    }
}
