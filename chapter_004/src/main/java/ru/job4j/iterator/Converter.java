package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Создать convert(Iterator<Iterator>)
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 15.01.2019
 */
public class Converter {

    /**
     *
     * @param it - an iterator of iterators, that need to iterate
     * @return a value from iterator that get from main iterator
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> iterator;

            /**
             * Returns true if the iteration has more elements.
             * (In other words, returns true if next would
             * return an element rather than throwing an exception.)
             *
             * @return {@code true} if the iteration has more elements
             */
            @Override
            public boolean hasNext() {
                boolean result = true;
                if (it.hasNext()) {
                    if (iterator == null || !iterator.hasNext()) {
                        iterator = it.next();
                        while (!iterator.hasNext()) {
                            if (!it.hasNext()) { // here check NPE
                                return false;
                            } else {
                                iterator = it.next();
                            }
                        }
                    }
                } else if (!iterator.hasNext()) {
                    result = false;
                }
                return result;
            }

            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             * @throws NoSuchElementException if the iteration has no more elements
             */
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
