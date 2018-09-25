package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BoardTest {
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String rsl = board.paint(3, 3);
        String In = System.lineSeparator();
        assertThat(rsl, is(String.format("X X%s X %sX X%s", In, In, In)));
    }

    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String rsl = board.paint(5, 4);
        String In = System.lineSeparator();
        assertThat(rsl, is(String.format("X X X%s X X %sX X X%s X X %s", In, In, In, In)));
    }
}
