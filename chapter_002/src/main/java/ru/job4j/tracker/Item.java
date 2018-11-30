package ru.job4j.tracker;

import java.util.Random;
import static java.util.Arrays.*;

public class Item {
    private String id;
    private String name;
    private String[] comments = new String[10];
    private int index;


    public Item(String name, String comments) {
        this.name = name;
        this.addComments(comments);
        this.id = (String.valueOf(new Random().nextInt() + System.currentTimeMillis()));

    }
    public void addComments(String comments) {
        this.comments[index] = comments;
        this.index++;
    }
    public String[] getComments() {
        return copyOf(comments, index);
    }
    public String getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public int getIndex() {
        return this.index;
    }
}
