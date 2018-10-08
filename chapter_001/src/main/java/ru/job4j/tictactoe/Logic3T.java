package ru.job4j.tictactoe;

/**
 * Class Logic3T Крестики-нолики на JavaFX.
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 08.10.2018
 */
public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Check is winner X.
     * @return if winner X then true else false.
     */
    public boolean isWinnerX() {
        int cell = 0;
        for (int first = 0, second = 0; first < table.length; first++, second++) {
            if (table[first][second].hasMarkX()) {
                cell++;
                if (cell == 3) {
                    return true;
                }
            }
        }
        cell = 0;
        for (int first = table.length - 1, second = 0; first >= 0; first--, second++) {
            if (table[first][second].hasMarkX()) {
                cell++;
                if (cell == 3) {
                    return true;
                }
            }
        }
        cell = 0;
        for (int index = 0; index < table.length; index++) {
            cell = 0;
            for (Figure3T[] column : table) {
                if (column[index].hasMarkX()) {
                    cell++;
                    if (cell == 3) {
                        return true;
                    }
                }
            }
        }
        for (Figure3T[] row : table) {
            if (row[0].hasMarkX() && row[1].hasMarkX() && row[2].hasMarkX()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check is winner O
     * @return if winner O then true else false.
     */
    public boolean isWinnerO() {
        int cell = 0;
        for (int first = 0, second = 0; first < table.length; first++, second++) {
            if (table[first][second].hasMarkO()) {
                cell++;
                if (cell == 3) {
                    return true;
                }
            }
        }
        cell = 0;
        for (int first = table.length - 1, second = 0; first >= 0; first--, second++) {
            if (table[first][second].hasMarkO()) {
                cell++;
                if (cell == 3) {
                    return true;
                }
            }
        }
        cell = 0;
        for (int index = 0; index < table.length; index++) {
            cell = 0;
            for (Figure3T[] column : table) {
                if (column[index].hasMarkO()) {
                    cell++;
                    if (cell == 3) {
                        return true;
                    }
                }
            }
        }
        for (Figure3T[] row : table) {
            if (row[0].hasMarkO() && row[1].hasMarkO() && row[2].hasMarkO()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check has gap or hasn't.
     * @return if has gap true else false.
     */
    public boolean hasGap() {
        for (Figure3T[] outer :table) {
            for (Figure3T inner:outer) {
                if (!inner.hasMarkO() && !inner.hasMarkX()) {
                    return true;
                }
            }
        }
        return false;
    }
}
