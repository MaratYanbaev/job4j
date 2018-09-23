package ru.job4j.max;

/**
 * Class Max задание "4.2. Максимум из двух чисел".
 * @author Marat Yanbaev (yanbaevms@gmail.com).
 * @since 23.09.2018.
 */

public class Max {
    /**
     * Максимум из двух чисел.
     * @param first первое значение.
     * @param second второе значение.
     * @return maximum value
     */

    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
