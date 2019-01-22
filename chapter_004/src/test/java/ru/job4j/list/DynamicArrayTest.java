package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class DynamicArrayTest {

    private DynamicArray<Integer> it;
    private Iterator iterator;

    @Before
    public void setUp() {
        it = new DynamicArray<>();
        it.add(0);
        it.add(1);
        it.add(2);
        it.add(3);
        it.add(4);
        it.add(5);
        it.add(6);
        it.add(7);
        it.add(8);
        it.add(9);

        iterator = it.iterator();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenTryGetTenthIndexBeforeGrowArrayThenArrayIndexOutOfBoundsException() {
        it.get(10);
    }

    @Test
    public void whenAddExtraValueAndTryGetEleventhIndexThenNull() {
        it.add(10);

        assertThat(it.get(11), is(nullValue()));
    }

    @Test
    public void whenGetOneOfValue() {
        assertThat(it.get(2), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnNumbersSequentiallyThenNextAndException() {
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(0));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(7));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(8));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(9));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {


        assertThat(iterator.next(), is(0));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.next(), is(7));
        assertThat(iterator.next(), is(8));
        assertThat(iterator.next(), is(9));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(0));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(7));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(8));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(9));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(0));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.next(), is(7));
        assertThat(iterator.next(), is(8));
        assertThat(iterator.next(), is(9));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenGetNextElementAfterAddNewDateThenException() {

        assertThat(iterator.next(), is(0));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(6));
        assertThat(iterator.next(), is(7));
        assertThat(iterator.next(), is(8));
        it.add(20);
        assertThat(iterator.next(), is(9));
    }

}