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
        int value = 0;
        for (int first = 0, second = 0; first < table.length; first++, second++) {
            if (table[first][second].hasMarkX()) {
                value++;
                if (value == 3) {
                    return true;
                }
            }
        }
        value = 0;
        for (int first = table.length - 1, second = 0; first >= 0; first--, second++) {
            if (table[first][second].hasMarkX()) {
                value++;
                if (value == 3) {
                    return true;
                }
            }
        }
        value = 0;
        for (int vertical = 0; vertical < table.length; vertical++) {
            value = 0;
            for (int first = 0; first < table.length; first++) {
                if (table[first][vertical].hasMarkX()) {
                    value++;
                    if (value == 3) {
                        return true;
                    }
                }
            }
        }
        for (Figure3T[] horizon : table) {
            if (horizon[0].hasMarkX() && horizon[1].hasMarkX() && horizon[2].hasMarkX()) {
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
        int value = 0;
        for (int first = 0, second = 0; first < table.length; first++, second++) {
            if (table[first][second].hasMarkO()) {
                value++;
                if (value == 3) {
                    return true;
                }
            }
        }
        value = 0;
        for (int first = table.length - 1, second = 0; first >= 0; first--, second++) {
            if (table[first][second].hasMarkO()) {
                value++;
                if (value == 3) {
                    return true;
                }
            }
        }
        value = 0;
        for (int vertic = 0; vertic < table.length; vertic++) {
            value = 0;
            for (int first = 0; first < table.length; first++) {
                if (table[first][vertic].hasMarkO()) {
                    value++;
                    if (value == 3) {
                        return true;
                    }
                }
            }
        }
        for (Figure3T[] horizon: table) {
            if (horizon[0].hasMarkO() && horizon[1].hasMarkO() && horizon[2].hasMarkO()) {
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
        for (Figure3T[] gapOut :table) {
            for (Figure3T gapIn:gapOut) {
                if (!gapIn.hasMarkO() && !gapIn.hasMarkX()) {
                    return true;
                }
            }
        }
        return false;
    }
}
