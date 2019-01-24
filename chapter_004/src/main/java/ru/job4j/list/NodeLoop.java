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
        boolean result = false;
        Node fast = first;
        Node slow = first;
        while (fast.next != first && fast.next != null && !result) {
            for (int i = 2; i > 0; i--) {
                fast = fast.next;
                if (fast.next == first) {
                    result = true;
                } else if (fast == slow || fast.next == null) {
                    return result;
                }

            }
            slow = slow.next;
        }
        return result;
    }
}
