package ru.job4j.loop;

/**
 * Class Paint - 5.4. Построить пирамиду в псевдографике.
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {

    /**
     * method pyramid.
     * @param height - высота пирамиды.
     * @return - возвращаем все добавленные символы и строки в одну строку.
     */
    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
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
