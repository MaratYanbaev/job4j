package ru.job4j.array;

/**
 * Class Turn решение 6.2. Перевернуть массив.
 * @author Marat Yanbaev  (yanbaevms@gmail.com)
 * @since 30.09.2018
 */
public class Turn {

    /**
     * Метод "переварачивает" массив.
     * @param array - массив, который необходимо "перевернуть".
     * @return - возвращаем "перевернутый" массив.
     */
    public int[] turn(int[] array) {
        for (int index = 0; index != array.length / 2; index++) {
            int temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
        }
        return array;
    }
}
