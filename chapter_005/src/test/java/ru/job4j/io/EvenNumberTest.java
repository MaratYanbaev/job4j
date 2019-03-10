package ru.job4j.io;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class EvenNumberTest {
    private EvenNumber en = new EvenNumber();
    private String a = "data";
    private boolean result;

    @Test
    public void testIsNumberMethodsThenGetFalse() {
        int[] units = {7, 11, 5, 15, 3, 9};
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(a)))) {
            for (int unit : units) {
                out.writeInt(unit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            result = en.isNumber(new DataInputStream(new BufferedInputStream(new FileInputStream(a))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assertThat(result, is(false));
    }

    @Test
    public void testIsNumberMethodsThenGetTrue() {
        int[] units = {7, 11, 5, 15, 4, 9};
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(a)))) {
            for (int unit : units) {
                out.writeInt(unit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            result = en.isNumber(new DataInputStream(new BufferedInputStream(new FileInputStream(a))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assertThat(result, is(true));
    }
}