package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayTest {

    private SimpleArray<Integer> it;
    private Iterator iterator;

    @Before
    public void setUp() {
        it = new SimpleArray<>(7);
        it.add(2);
        it.add(3);
        it.add(6);
        it.add(8);
        it.add(4);
        it.add(1);
        it.add(7);

        iterator = it.iterator();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenTryToAddExtraValueWhenArrayIsFullThenException() {
        it.add(10);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenTryToSetValueInNotExistIndexThenException() {
        it.set(10, 5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void tryToRemoveValueWhenIndexBiggerLengthThenException() {
        it.remove(7);
    }


    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenTryGetOneOfValueThenException() {
        it.get(8);
    }

    @Test
    public void whenGetOneOfValue() {
        assertThat(it.get(2), is(6));
    }

    @Test
    public void whenSetValueThenGetOne() {
        it.set(6, 5);
        assertThat(it.get(6), is(5));
    }

    @Test
    public void whenRemoveValueThenGetNull() {
        it.remove(2);
        assertThat(it.get(6), is(nullValue()));
    }

    @Test
    public void whenRemoveValueThenGetNext() {
        it.remove(2);
        assertThat(it.get(2), is(8));
    }


    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(8));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(7));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        Iterator<Integer> iterator = it.iterator();

        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.next(), is(8));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(7));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(8));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(7));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.next(), is(8));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(7));
    }

    @Test
    public void hasOneNextShouldReturnFalseInCaseOfEmptyIterators() {
        SimpleArray<Integer> empty = new SimpleArray<>(10);
        Iterator<Integer> em = empty.iterator();
        assertThat(em.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void invocationOfNextMethodShouldThrowNoSuchElementException() {
        SimpleArray<Integer> empty = new SimpleArray<>(10);
        Iterator<Integer> em = empty.iterator();
        em.next();
    }
}