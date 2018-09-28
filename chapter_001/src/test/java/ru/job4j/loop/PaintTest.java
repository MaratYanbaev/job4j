package ru.job4j.loop;

import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @version &Id&
 * @since 0.1
 */
public class PaintTest {
    /**
     * Test pyramid.
     */
    @Test
    public void whenPyramid4Right() {
        Paint paint = new Paint();
        String rst = paint.rightTrl(4);
        System.out.println(rst);
        assertThat(rst, is(
                new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("^   ")
                .add("^^  ")
                .add("^^^ ")
                .add("^^^^")
                .toString()
        ));
    }
    @Test
    public void whenPyramid4Left() {
        Paint paint = new Paint();
        String rst = paint.leftTrl(4);
        System.out.println(rst);
        assertThat(rst, is(
                new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("   ^")
                        .add("  ^^")
                        .add(" ^^^")
                        .add("^^^^")
                        .toString()
        ));
    }
    @Test
    public void whenPyramid2Height() {
        Paint paint = new Paint();
        String rst = paint.pyramid(2);
        assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(" ^ ")
                .add("^^^")
                .toString()
        ));
    }

    @Test
    public void whenPyramid3Height() {
        Paint paint = new Paint();
        String rst = paint.pyramid(3);
        assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("  ^  ")
                .add(" ^^^ ")
                .add("^^^^^")
                .toString()
        ));
    }

    @Test
    public void whenPyramidTwoHeight() {
        MyOwnPaint paint = new MyOwnPaint();
        String rst = paint.myOwnPyramid(2);
        assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(" ^ ")
                .add("^^^")
                .toString()
        ));
    }

    @Test
    public void whenPyramidFourHeight() {
        MyOwnPaint paint = new MyOwnPaint();
        String rst = paint.myOwnPyramid(4);
        assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("   ^   ")
                .add("  ^^^  ")
                .add(" ^^^^^ ")
                .add("^^^^^^^")
                .toString()
        ));
    }
}
