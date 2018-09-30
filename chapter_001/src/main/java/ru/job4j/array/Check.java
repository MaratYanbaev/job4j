package ru.job4j.array;

/**
 * Class Check 6.3. Массив заполнен true или false.
 * @author Marat Yanbaev  (yanbaevms@gmail.com)
 * @since 30.09.2018
 */
public class Check {
    /**
     * method mono - проверка массива.
     * @param data - массив для проверки.
     * @return - вернет является ли массив true или false
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (boolean fOrT: data) {
            if (!fOrT) {
                result = fOrT;
                break;
            }
            result = fOrT;
        }
        return result;
    }
}
