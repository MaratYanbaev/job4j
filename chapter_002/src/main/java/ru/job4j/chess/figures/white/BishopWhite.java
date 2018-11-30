package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import static java.lang.Math.abs;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
@SuppressWarnings("ALL")
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int index = 0;
        int stepsIndex = 0;
        Cell rst;
        if (source.x + source.y == dest.x + dest.y || source.x - source.y == dest.x - dest.y) {
            index = abs(dest.y - source.y);
        }
        Cell[] steps = new Cell[index];
        if (source.x + source.y == dest.x + dest.y || source.x - source.y == dest.x - dest.y) {
            int deltaX = (dest.x - source.x) / abs(dest.x - source.x);
            int deltaY = (dest.y - source.y) / abs(dest.y - source.y);
            Cell[] copy = Cell.values();
            for (int i = 0; i < copy.length; i++) {
                if (copy[i].x == source.x + deltaX && copy[i].y == source.y + deltaY) {
                    rst = copy[i];
                    steps[stepsIndex] = copy[i];
                    stepsIndex++;
                    i = 0;
                    deltaX += (dest.x - source.x) / abs(dest.x - source.x);
                    deltaY += (dest.y - source.y) / abs(dest.y - source.y);
                } else if (stepsIndex == steps.length) {
                    break;
                }
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
