package ru.job4j.loop;

/**
 * Class Board
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 25.09.2018
 */

public class Board {

    /**
     * method paint.
     * @param width - задает ширину доски.
     * @param height - задает высоту доски.
     * @return - возращаем все добавленные символы и строки.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String In = System.lineSeparator();
        for (int h = 0; height > h; h++) {
            for (int w = 0; width > w; w++) {
                if (((h + w) % 2) == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(In);
        }
        return screen.toString();
    }
}