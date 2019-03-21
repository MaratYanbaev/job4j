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

    /**
     * массив символов являющиеся признаком окончания слова
     * и начала нового.
     */
    char[] set = new char[] {' ', '.', ',', '?', '-',
            '!', ':', ';', '(', ')'};

    char[] chars = new char[15];


    void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        try (Reader r = new InputStreamReader(in, StandardCharsets.UTF_8);
             Writer w = new OutputStreamWriter(out)) {
            char ch;
            int ich;
            int index = 0;
            boolean sc = false; // найден ли символ из массива set
            boolean ss = false;
            while ((ich = r.read()) != -1) {
                ch = (char) ich;
                for (char c : set) {
                    if (c == ch) { // ищем признак окончания слова
                        sc = true;
                        if (!ss) { // был ли до этого символ из массива set
                            String word = new String(chars, 0, index);
                            for (String ab : abuse) { // проверяем слово "word" из потока с массивом слов abuse
                                if (ab.equalsIgnoreCase(word)) {
                                    index = 0;
                                }
                            } // если слово не входит в список abuse записываем его в OutputStream out
                            w.write(chars, 0, index);
                            index = 0;
                            break;
                        }
                    }
                }
                if (sc) { // найден ли символ из массива set
                    sc = false;
                    ss = true;
                    w.write(ich); //записываем найденный символ из массива set в OutputStream out
                } else {
                    ss = false;
                    chars[index++] = ch; // буферизация символов из потока пока не встретится символ из мссива set
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
