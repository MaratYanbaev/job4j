package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class NodeLoopTest {

    private NodeLoop nl;

    private Node<Integer> start;
    private Node<Integer> first;
    private Node<Integer> end;

    @Before
    public void setUp() {
        nl = new NodeLoop();

        this.start = new Node<>(1);
        first = new Node<>(2);
        Node<Integer> second = new Node<>(3);
        Node<Integer> third = new Node<>(4);
        Node<Integer> fourth = new Node<>(5);
        Node<Integer> fifth = new Node<>(6);
        end = new Node<>(7);

        start.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = end;
        end.next = start;
    }

    @Test
    public void checkHasListLoopThenTrue() {
        assertThat(nl.hasCycle(start), is(true));
    }

    @Test
    public void checkHasListLoopThenFalse() {
        end.next = new Node<>(8);

        assertThat(nl.hasCycle(start), is(false));
    }

    @Test
    public void whenListNotLoopThenFalse() {
        end.next = first;

        assertThat(nl.hasCycle(start), is(false));
    }

}