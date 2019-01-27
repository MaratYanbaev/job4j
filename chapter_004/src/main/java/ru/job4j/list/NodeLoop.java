package ru.job4j.list;

/**
 * 5.3.4. Задан связанный список. Определить цикличность.[#105795]
 *
 * Задан связанный список.
 *
 * class Node<T> {
 *    T value;
 *    Node<T> next;
 * }
 *
 * Node first = new Node(1);
 * Node two = new Node(2);
 * Node third = new Node(3);
 * Node four = new Node(4);
 *
 * first.next = two;
 * two.next = third;
 * third.next = four;
 * four.next = first;
 *
 * Написать алгоритм определяющий, что список содержит замыкания.
 *
 * boolean hasCycle(Node first);
 *
 * Обратите внимание, что список может быть замкнут и в середине.
 * К примеру, 3-й узел будет ссылаться на 2-й узел.
 * Определение зацикленности необходимо реализовать путем прохода по узлам,
 * без использования коллекций.
 *
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
        Node fast = first;
        Node slow = first;
//        while (fast.next != first && fast.next != null && !result) {
//            for (int i = 2; i > 0; i--) {
//                fast = fast.next;
//                if (fast.next == first) {
//                    result = true;
//                } else if (fast == slow || fast.next == null) {
//                    return result;
//                }
//
//            }
//            slow = slow.next;
//        }
        while (fast.next != null && fast.next.next != null && fast.next != first) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        return fast.next == first;
    }
}
