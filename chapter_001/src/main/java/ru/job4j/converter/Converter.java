package ru.job4j.converter;

public class Converter {
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Конвертируем рубли в евро.
     * @param value увро.
     * @return Рубли.
     */
    public int euroToRuble(int value) {
        return value * 70;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары.
     */
    public  int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value доллар.
     * @return Рубли.
     */
    public  int dollarToRuble(int value) {
        return value * 60;
    }
}
