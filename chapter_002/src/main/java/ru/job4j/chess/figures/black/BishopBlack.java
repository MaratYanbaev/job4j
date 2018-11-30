package ru.job4j.chess.figures.black;

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
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (source != dest && (source.x + source.y == dest.x + dest.y || source.x - source.y == dest.x - dest.y)) {
            steps = new Cell[abs(dest.y - source.y)];
            int deltaX = (dest.x - source.x) / abs(dest.x - source.x);
            int deltaY = (dest.y - source.y) / abs(dest.y - source.y);
            for (int i = 0; i < Cell.values().length; i++) {
                if (Cell.values()[i].x == source.x + deltaX && Cell.values()[i].y == source.y + deltaY) {
                    steps[abs(deltaX) - 1] = Cell.values()[i];
                    deltaX += (dest.x - source.x) / abs(dest.x - source.x);
                    deltaY += (dest.y - source.y) / abs(dest.y - source.y);
                    i = 0;
                } else if (steps.length == abs(deltaX) - 1) {
                    break;
                }
            }
        }
        return steps;
    }
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
