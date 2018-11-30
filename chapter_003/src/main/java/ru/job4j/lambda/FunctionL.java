package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import static java.lang.Math.*;

public class FunctionL {



    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> line = new ArrayList<>();
        double max = max(start, end);
        double min = min(start, end);
        while (max >= min) {
            line.add(func.apply(min++));
        }
        return line;
    }
}
