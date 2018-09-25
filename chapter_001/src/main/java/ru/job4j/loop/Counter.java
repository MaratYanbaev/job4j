package ru.job4j.loop;

/**
 * Class Counter.
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 25.09.2018
 */
public class Counter {
    int result;
    /**
     * method evenNumber.
     * @param start - начальное значение диапазона
     * @param finish - конечное значение дипазона
     * @return - возвращает сумму четных чисел
     * в диапазоне значений start - finish.
     */
    public int evenNumber(int start, int finish) {
        for (int one = start; one <= finish; one++) {
            if (one % 2 == 0) {
                result += one;
            }
        }
        return result;
    }
}
