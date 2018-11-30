package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static java.lang.String.format;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект.
     */
    private Input input;
    /**
     * @param хранит ссылку на объект.
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction
     */
    private List<UserAction> actions = new ArrayList<>();

    private final Consumer<String> output;

    /**
     * Конструктор.
     *  @param input   объект типа Input
     * @param tracker объект типа Tracker
     * @param output
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.fillActions();
        this.output = output;
    }

    public void fillActions() {
        this.actions.add(new AddItem(0, " - Завести новую карту.\n"));
        this.actions.add(new ShowAllItems(1, " - Показать все карты.\n"));
        this.actions.add(new ChangeItem(2, " - Заменить карту другой картой.\n"));
        this.actions.add(new DeleteItem(3, " - Удалить карту.\n"));
        this.actions.add(new FindById(4, " - Найти карту по индетефикатору Id.\n"));
        this.actions.add(new FindByName(5, " - Найти карту по имени.\n"));
        this.actions.add(new AddComment(6, " - Добавить комментарий.\n"));
        this.actions.add(new Exit(7, " - Покинуть программу.\n\n"));
    }
    /**
     * Метод для получения массива меню.
     *
     * @return длину массива.
     */
    public int getActionLength() {
        return this.actions.size();
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соответствующие действия.
     *
     * @param key ключ операции.
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        output.accept("--------------- Меню. ----------------\n\n");
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------- Длобавление новой карты -------\n\n");
            String name = input.ask("Введите имя карты.");
            String comment = input.ask("Введите комментарий.");
            Item item  = new Item(name, comment);
            tracker.add(item);
            output.accept("Заведена новая карта Id №" + item.getId() + "\n\n");
        }
    }

    private class ShowAllItems extends BaseAction {

        public ShowAllItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            if (tracker.getItems().isEmpty()) {
                output.accept("Не заведена еще ни одна карта.\n");
            }
            List<Item> result = tracker.getItems();
            for (Item item : result) {
                output.accept("Имя - " + item.getName() + "\nid - " + item.getId() + "\n");
            }
        }
    }

    private class ChangeItem extends BaseAction {

        public ChangeItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заменяемой карты.");
            if (tracker.findById(id) == null) {
                output.accept("Карты по данному id не существует.\n\n");
            } else {
                String name = input.ask("Введите имя новой карты.");
                String comment = input.ask("Введите комментарии по карте.");
                Item item  = new Item(name, comment);
                tracker.replace(id, item);
                output.accept("Карта №" + id + " заменина новой картой id №" + item.getId() + "\n");
            }
        }
    }

    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id удаляемой карты");
            if (tracker.delete(id)) {
                System.out.print("Карта удалена.\n\n");
            } else {
                output.accept("Карты по данному id не существует.\n\n");
            }
        }
    }

    private class FindById extends BaseAction {

        public FindById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("Введите номер id."));
            if (item == null) {
                output.accept("Карты по данному id не существует.\n\n");
            } else {
                output.accept("\nИмя " + item.getName() + "\n");
                output.accept("Комментарий:\n");
                int numOfComment = 1;
                for (String comment : item.getComments()) {
                    output.accept(format("%d - %s\n", numOfComment++, comment));
                }
            }
        }
    }

    private class FindByName extends BaseAction {

        public FindByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            ArrayList<Item> result = tracker.findByName(input.ask("Введите Имя."));
            if (result == null) {
                output.accept("Карты по данному имени не существует.\n\n");
            } else {
                int numOfComment = 1;
                for (Item item : result) {
                    output.accept("id - " + item.getId() + "\n");
                    output.accept("Комментарий:\n");
                    for (String comment : item.getComments()) {
                        output.accept(format("%d - %s\n", numOfComment++, comment));
                    }
                }

            }
        }
    }

    private class AddComment extends BaseAction {

        public AddComment(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите номер id карты.");
            Item item = tracker.findById(id);
            if (item == null) {
                output.accept("Карты по данному id не существует.\n\n");
            } else if (item.getIndex() == 10) {
                output.accept("По данной карте больше нельзя добавить комментарий.\nМаксимум 10 комминтариев.\n");
            } else {
                String comment = input.ask("Напишите комментарий.");
                item.addComments(comment);
                output.accept("Комментарий добавлен.\n");
            }
        }
    }

    private class Exit extends BaseAction {

        public Exit(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }
    }
}
