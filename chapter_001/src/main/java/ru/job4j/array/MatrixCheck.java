package ru.job4j.array;

/**
 * Class MatrixCheck решение задачи 6.7. Квадратный массив заполнен true или false по диагоналям. [#53859]
 * @author Marat Yanbaev (yanbaevms@gamil.com)
 * since 2.10.2018
 */
public class MatrixCheck {

    /**
     * Проверка массива по диагонали true or false
     * @param data - input array
     * @return - true or false
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int first = 0, second = 0; first < data.length; first++, second++) {
            if (data[0][0] != data[first][second]) {
                result = false;
                break;
            }
        }
        if (result) {
            for (int first = data.length - 1, second = 0; first >= 0; first--, second++) {
                if (data[data.length - 1][0] != data[first][second]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
