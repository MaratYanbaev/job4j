package ru.job4j.loop;

/**
 * Class Factorial.
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 25.09.2018
 */

public class Factorial {
    int result = 1;

    /**
     * method factorial
     * @param f - значение для вычисления факториала.
     * @return - возвращает факториал значения f.
     */
    public int factorial(int f) {
        for (int one = 1; one <= f; one++) {
            result = result * one;
        }
        return result;
    }
}
