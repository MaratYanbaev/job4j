package ru.job4j.array;

/**
 * Class Calculate решение задачи 6.1. Классический поиск перебором.
 * @author Marat Yanbaev  (yanbaevms@gmail.com)
 * @since 29.09.2018
 */
public class FindLoop {

    /**
     * method indexOf.
     * @param data - массив в котором необходимо найти значение.
     * @param el - искомое значение.
     * @return - возвращаем индекс (адрес) найденного значения
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for(int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
