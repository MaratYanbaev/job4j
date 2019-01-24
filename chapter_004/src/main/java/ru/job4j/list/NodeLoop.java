package ru.job4j.list;

/**
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 24.01.2019
 */
public class NodeLoop {

    /**
     *
     * @param first - the start of hasCycle
     * @return - if list has hasCycle true otherwise false
     */
    public boolean hasCycle(Node first) {
        Node buf = first;
        while (buf.next != first && buf.next != null) {
            buf = buf.next;
        }
        return buf.next != null;
    }
}
