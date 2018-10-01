package ru.job4j.array;

public class ArrayChar {
    private char[] data;

    /**
     * @param line - проверяемое слово.
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяем, начинается ли слово с заданного префикса.
     * @param prefix - заданный префикс.
     * @return - true if line starts to prefix, else false.
     */
    public boolean starWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int med = 0; med < value.length; med++) {
            if (value[med] != data[med]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
