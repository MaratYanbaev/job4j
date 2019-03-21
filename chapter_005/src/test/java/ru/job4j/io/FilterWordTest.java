package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class FilterWordTest {
    FilterWord filterWord;
    File file;
    String[] set;

    @Before
    public void set() {
        filterWord = new FilterWord();
        file = new File("excerpt");
        set = new String[]{"время", "зима", "ветер", "лишь", "поохотиться", "Только", "спит"};
    }

    @Test
    public void checkMethod() {
        try (BufferedInputStream is = new BufferedInputStream(
                new FileInputStream(file));
            BufferedOutputStream os = new BufferedOutputStream(
                    new FileOutputStream("SortExcerpt"))) {
            filterWord.dropAbuses(is, os, set);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}