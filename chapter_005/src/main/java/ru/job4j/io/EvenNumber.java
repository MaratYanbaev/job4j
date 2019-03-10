package ru.job4j.io;

import java.io.*;

/**
 * 1. Проверить байтовый поток[#105858]
 *
 * Реализовать сервис:
 * boolean isNumber(InputStream in);
 * Метод должен проверить, что в байтовом потоке записано четное число.
 * Все потоки должны быть обернуты через try-with-resources, даже, если это ByteArrayInputStream.
 *
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 10.03.2019
 */
public class EvenNumber {

    /**
     *
     * @param in - stream
     * @return true if stream has even number otherwise false
     */
    boolean isNumber(InputStream in) {
        boolean result = false;
        try (DataInputStream input = new DataInputStream(new BufferedInputStream(in))) {
            while (true) {
                if ((input.readInt() % 2) == 0) {
                    result = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
