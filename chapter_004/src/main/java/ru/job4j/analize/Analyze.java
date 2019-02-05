package ru.job4j.analize;

import java.util.List;
import java.util.Random;

/**
 * @author Marat Yanbaev (yanbaevms@gmail.com)
 * @since 04.02.2019
 */
public class Analyze {

    /**
     *
     * @param previous - исходная коллекция.
     * @param current - измененная коллекция.
     * @return - информацию об изменениях в исходной коллекции.
     */
    public Info diff(List<User> previous, List<User> current) {
        int old = 0;
        int changed = 0;
        int added, delete;
        for (User out: previous) {
            for (User inner: current) {
                if (out.getId().equals(inner.getId())) {
                    old++;
                    if (!(out.getName().equals(inner.getName()))) {
                        changed++;
                        old--;
                    }
                }
            }
        }
        added = current.size() - old - changed;
        delete = previous.size() - old - changed;
        return new Info(added, changed, delete);
    }

    public static class User {
        private String id;
        private String name;

        public User(String name) {
            this.name = name;
            this.id = (String.valueOf(new Random().nextInt() + System.currentTimeMillis()));
        }

        public User(User user) {
            this.name = user.getName();
            this.id = user.getId();
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void newName(String name) {
            this.name = name;
        }
    }

    public static class Info {
        private int added;
        private int changed;
        private int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }

    }
}
