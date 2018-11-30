package ru.job4j.tracker;

import java.util.function.Consumer;

public class StartUI {
    private int[] ranges;
    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;

    /**
     * Конструктор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        ranges = new int[menu.getActionLength()];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = i;
        }
        int key;
        do {
            menu.show();
            key = (input.ask("Введите пункт меню.", ranges));
            menu.select(key);
        } while (ranges[ranges.length - 1] != key);
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::print).init();
    }
}
