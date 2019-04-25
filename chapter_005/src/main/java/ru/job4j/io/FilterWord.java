package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 2. Удаление запрещенных слов[#105859]
 * Реализовать сервис: void dropAbuses(InputStream in, OutputStream out, String[] abuse)
 * Задан входной символьный поток и выходной символьный поток. Надо удалить все слова,
 * входящие в массив abuse. Важно, все преобразования нужно делать в потоке.
 * Нельзя зачитать весь поток в память, удалить слова и потом записать.
 * Нужно все делать в потоке.
 *
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 18.03.2019
 */
public class FilterWord {

    void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
             Writer w = new OutputStreamWriter(out)) {
            String result = reader.readLine();
            while (result != null) {
                for (String ab : abuse) {
                    result = result.replaceAll(ab, "УПС");
                }
                w.write(result + "\n");
                result = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
