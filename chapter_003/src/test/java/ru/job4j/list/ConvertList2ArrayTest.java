package ru.job4j.list;

import static org.junit.Assert.assertThat;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7), 3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when11ElementsThen16() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), 5
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 0},
                {0, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenListHasArraysThenList() {
        ConvertList2Array array = new ConvertList2Array();
        List<int[]> list = List.of(
                (new int[]{1, 2}),
                (new int[]{3, 4, 5, 6}),
                (new int[]{7, 8, 9})
        );
        List<Integer> result = array.convert(list);
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9
        );
        assertThat(result, is(expect));
    }
}