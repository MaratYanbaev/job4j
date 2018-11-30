package ru.job4j.tracker;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] ranges) {
        boolean invalid = true;
        int key = -1;
        do {
            try {
                key = this.input.ask(question, ranges);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.print("Пожайлуста введите номер из дипазона пунктов.\n\n");
            } catch (NumberFormatException nfe) {
                System.out.print("Пожайлуста введите только номер пункта.\n\n");
            }
        } while (invalid);
        return key;
    }
}
