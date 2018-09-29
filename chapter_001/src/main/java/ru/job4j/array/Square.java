package ru.job4j.array;
/**
 * Class Square решение задачи 6.0. Заполнить массив степенями чисел.
 * @author Marat Yanbaev  (yanbaevms@gmail.com)
 * @since 0.1  29.09.2018
 */
public class Square {

    /**
     * method calculate.
     * @param bound - длина массива.
     * @return - возвращаем массив заполненый степенями чисел.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for(int value = 0; value != rst.length; value ++) {
            rst[value] = (int) Math.pow((value + 1), 2);
        }
        return rst;
    }
}
