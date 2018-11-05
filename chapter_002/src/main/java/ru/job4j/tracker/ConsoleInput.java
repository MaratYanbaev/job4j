package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question + "\n");
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, int[] ranges) {
        int key = Integer.parseInt(this.ask(question));
        boolean exist = false;
        for (int value : ranges) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Пожайлуста введите номер из дипазона пунктов.\n\n");
        }
        return key;
    }
}
