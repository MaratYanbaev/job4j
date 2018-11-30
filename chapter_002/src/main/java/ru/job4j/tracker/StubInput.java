package ru.job4j.tracker;

public class StubInput implements Input {

    private final String[] value;
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    public String ask(String question) {
        return this.value[this.position++];
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
        return exist ? key : -1;
    }
}
