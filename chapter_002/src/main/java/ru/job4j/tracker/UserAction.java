package ru.job4j.tracker;

public interface UserAction {
    int key();
    /**
     * Основной метод.
     * @param input объект типа Input
     * @param tracker объект типа Tracker
     */
    void execute(Input input, Tracker tracker);
    /**
     * Методо возвращает информацию о данном пункте меню.
     * @return Строка меню.
     */
    String info();
}
