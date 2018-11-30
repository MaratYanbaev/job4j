package ru.job4j.chess;

import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.Cell;

import java.util.Arrays;

import static java.util.Arrays.asList;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        /*
        int index = this.findBy(source);
        if (index != -1) {*/
        Figure figure = this.findBy(source);
        if (figure != null) {
            /*
            Cell[] steps = this.figures[index].way(source, dest);*/
            Cell[] steps = figure.way(source, dest);
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                if (this.wayIsFree(steps)) {
                    rst = true;
                    /*
                    this.figures[index] = this.figures[index].copy(dest);*/
                    this.figures[asList(figures).indexOf(figure)] = figure.copy(dest);
                }
            }
        }
        return rst;
    }

    private boolean wayIsFree(Cell[] cell) {
        boolean busyWay = true;
        for (Cell c: cell) {
            busyWay = Arrays.stream(figures).noneMatch(f -> c.equals(f.position()));
            if (!busyWay) {
                break;
            }
        /*for (Figure figure: figures) {
                if (c.equals(figure.position())) {
                    busyWay = false;
                }
            }*/
        }
        return busyWay;
    }

    public void clean() {
        Arrays.stream(figures).forEach(figure -> figure = null);
        /*
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }*/
        this.index = 0;
    }

 /*   private int findBy(Cell cell) {*/
        private Figure findBy(Cell cell) {
        /*int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;*/
        return Arrays.stream(figures).
                filter(f -> f != null && f.position().equals(cell)).
                findFirst().
                orElse(null);
    }
}
