package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Class Paint - 5.4. Построить пирамиду в псевдографике.
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {

    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * method loopBy
     * @param height - высота пирамиды.
     * @param weight - ширина пирамиды.
     * @param predicate - ?
     * @return - возвращаем все символы и пробелы в одну строку.
     */
    public String loopBy(int height, int weight, BiPredicate<Integer, Integer> predicate) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predicate.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
