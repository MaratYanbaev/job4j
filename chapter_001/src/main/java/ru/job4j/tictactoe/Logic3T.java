package ru.job4j.tictactoe;

/**
 * Class Logic3T Крестики-нолики на JavaFX.
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 08.10.2018
 */
public class Logic3T {
    private boolean result = false;
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
        for (int index = 0; index < table.length; index++) {
            if (table[index][index].hasMarkX()) {
                cell++;
                if (cell == table.length) {
                    result = true;
                }
            }
        }
        cell = 0;
        for (int first = table.length - 1, second = 0; first >= 0; first--, second++) {
            if (table[first][second].hasMarkX()) {
                cell++;
                if (cell == table.length) {
                    result = true;
                }
            }
        }
        cell = 0;
        for (int index = 0; index < table.length; index++) {
            cell = 0;
            for (Figure3T[] column : table) {
                if (column[index].hasMarkX()) {
                    cell++;
                    if (cell == column.length) {
                        result = true;
                    }
                }
            }
        }
        for (Figure3T[] row : table) {
            for (int index = row.length - 1; index >= 0; index--) {
                if (row[index].hasMarkX()) {
                    cell++;
                    if (cell == row.length) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Check is winner O
     * @return if winner O then true else false.
     */
    public boolean isWinnerO() {
        int cell = 0;
        for (int index = 0; index < table.length; index++) {
            if (table[index][index].hasMarkO()) {
                cell++;
                if (cell == table.length) {
                    result = true;
                }
            }
        }
        cell = 0;
        for (int first = table.length - 1, second = 0; first >= 0; first--, second++) {
            if (table[first][second].hasMarkO()) {
                cell++;
                if (cell == table.length) {
                    result = true;
                }
            }
        }
        cell = 0;
        for (int index = 0; index < table.length; index++) {
            cell = 0;
            for (Figure3T[] column : table) {
                if (column[index].hasMarkO()) {
                    cell++;
                    if (cell == column.length) {
                        result = true;
                    }
                }
            }
        }
        for (Figure3T[] row : table) {
            for (int index = row.length - 1; index >= 0; index--) {
                if (row[index].hasMarkO()) {
                    cell++;
                    if (cell == row.length) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Check has gap or hasn't.
     * @return if has gap true else false.
     */
    public boolean hasGap() {
        for (Figure3T[] outer :table) {
            for (Figure3T inner:outer) {
                if (!inner.hasMarkO() && !inner.hasMarkX()) {
                    result = true;
                }
            }
        }
        return result;
    }
}
