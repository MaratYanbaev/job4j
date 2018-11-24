package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позицию определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(task);
        } else {
            for (int k = tasks.size() - 1; k >= 0; k--) {
                if (task.getPriority() >= tasks.get(k).getPriority()) {
                    tasks.add(k + 1, task);
                    break;
                } else if (k == 0) {
                    tasks.add(0, task);
                }
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
