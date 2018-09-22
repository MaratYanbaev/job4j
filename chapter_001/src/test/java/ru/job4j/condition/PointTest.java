package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void distance() {
        Point a = new Point(1, 2);
        Point b = new Point(4, 5);

        double result = a.distanceTo(b);
        assertThat(result, closeTo(4.24, 0.01));
    }
}
