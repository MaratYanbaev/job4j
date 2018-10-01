package ru.job4j.array;

/**
 * Class BubbleSort решение задачи 6.5. Создать программу для сортировки массива методом перестановки. [#195]
 * @author Marat Yanbev (yanbaevms@gmail.com)
 * @since 1.10.2018
 */
public class BubbleSort {

    /**
     * Метод сортировки массива.
     * @param sort - массив для сортировки.
     * @return - sorted array.
     */
    public int[] bubbleSort(int[] sort) {
        for (int loop = sort.length - 1; loop > 0; loop--){
            for (int inLoop = 0; inLoop < loop; inLoop++ ) {
                if (sort[inLoop] > sort[inLoop + 1]) {
                    int buf = sort[inLoop];
                    sort[inLoop] = sort[inLoop + 1];
                    sort[inLoop + 1] = buf;
                }
            }
        }
        return sort;
    }
}
