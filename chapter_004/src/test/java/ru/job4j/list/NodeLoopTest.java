package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class NodeLoopTest {

    private NodeLoop nl;

    private Node<Integer> first;
    private Node<Integer> fourth;

    @Before
    public void setUp() {
        nl = new NodeLoop();

        this.first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        fourth = new Node<>(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
    }

    @Test
    public void checkHasListLoopThenTrue() {
        assertThat(nl.hasCycle(first), is(true));
    }

    @Test
    public void checkHasListLoopThenFalse() {
        fourth.next = new Node<>(5);

        assertThat(nl.hasCycle(first), is(false));
    }

}