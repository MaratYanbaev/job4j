package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 15.01.2019
 */
public class Converter {
    private Iterator<Integer> iterator;
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                boolean result = true;
                if (it.hasNext()) {
                    if (iterator == null || !iterator.hasNext()) {
                        iterator = it.next();
                        while (!iterator.hasNext()) {
                            iterator = it.next();
                            if (!it.hasNext()) { // here check NPE
                                return false;
                            }
                        }
                    }
                } else if (!iterator.hasNext()) {
                    result = false;
                }
                return result;
            }

            @Override
            public Integer next() {
                if (this.hasNext()) {
                    return iterator.next();
                }
                throw new NoSuchElementException();
            }
        };
    }
}
