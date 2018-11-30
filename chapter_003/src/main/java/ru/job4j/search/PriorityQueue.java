package ru.job4j.search;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позицию определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        tasks.add(task);
    }

    public Task take() {
        return tasks.stream().
                sorted(Comparator.comparingInt(Task::getPriority)).
                collect(Collectors.toCollection(LinkedList::new)).poll();
    }
}
