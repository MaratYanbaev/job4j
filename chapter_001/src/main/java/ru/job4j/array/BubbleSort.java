package ru.job4j.array;

/**
 * Class BubbleSort решение задачи 6.5. Создать программу для сортировки массива методом перестановки. [#195]
 * @author Marat Yanbev (yanbaevms@gmail.com)
 * @since 1.10.2018
 */
public class BubbleSort {

    /**
     * Метод сортировки массива.
     * @param array - массив для сортировки.
     * @return - sorted array.
     */
    public int[] arraySort(int[] array) {
        for (int outLoop = array.length - 1; outLoop > 0; outLoop--) {
            for (int inLoop = 0; inLoop < outLoop; inLoop++) {
                if (array[inLoop] > array[inLoop + 1]) {
                    int buf = array[inLoop];
                    array[inLoop] = array[inLoop + 1];
                    array[inLoop + 1] = buf;
                }
            }
        }
        return array;
    }
}
