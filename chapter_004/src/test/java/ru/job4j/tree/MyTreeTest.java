package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MyTreeTest {
    @Test
    public void when6ElFindLastThen6() {
        MyTree<Integer> tree = new MyTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);

        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        MyTree<Integer> tree = new MyTree<>(1);
        tree.add(1, 2);

        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void tryAddExtraTheSameChildThenFalse() {
        MyTree<Integer> tree = new MyTree<>(1);
        tree.add(1, 2);

        assertThat(
                tree.add(1, 2),
                is(false)
        );

    }

    @Test
    public void tryAddChildToNotExistParentThenFalse() {
        MyTree<Integer> tree = new MyTree<>(1);
        tree.add(1, 2);

        assertThat(
                tree.add(3, 2),
                is(false)
        );
    }
}