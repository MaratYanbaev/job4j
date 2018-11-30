package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows + (list.size() % rows == 0 ? 0 : 1);
        int[][] array = new int[rows][cells];
        int i = 0, j = 0;
        for (int k: list) {
            if (j < cells) {
                array[i][j] = k;
                j++;
            } else {
                i++;
                j = 0;
                array[i][j] = k;
                j++;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        return list.stream().flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
    }

}
