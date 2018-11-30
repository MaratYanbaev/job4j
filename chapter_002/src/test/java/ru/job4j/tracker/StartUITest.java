package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream stdout = new PrintStream(out);
    private final Consumer<String> output = s -> stdout.print(s);

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "7"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.getItems().get(0).getName(), is("test name"));
    }
    @Test
    public void whenReplaceItemsThenTrackerHasUpdateValue() {
        Tracker tracker = new Tracker();
        Item item = new Item("test item", "desc");
        tracker.add(item);
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "7"});
        new StartUI(input, tracker, output).init();
        ArrayList<Item> newItem = tracker.getItems();
        assertThat(newItem.get(0).getName(), is("test replace"));
    }
    @Test
    public void whenDeleteItemThenTrackerDoesNotHaveThisItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test itemOne", "desc"));
        tracker.add(new Item("test itemTwo", "desc"));
        Item item = new Item("test itemThree", "desc");
        tracker.add(item);
        Input input = new StubInput(new String[]{"3", item.getId(), "7"});
        new StartUI(input, tracker, output).init();
        Item itemNull = null;
        assertThat(tracker.findById(item.getId()), is(itemNull));
    }
    @Test
    public void whenAddThreeItemsThenFindOneOfThemById() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test itemOne", "desc"));
        tracker.add(new Item("test itemTwo", "desc"));
        Item item = new Item("test itemThree", "desc");
        tracker.add(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "7"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }
    @Test
    public void whenAddThreeItemsThenFindOneOfThemByName() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("itemOne", "desc"));
        tracker.add(new Item("itemTwo", "desc"));
        Item item = new Item("itemThree", "desc");
        tracker.add(item);
        Input input = new StubInput(new String[]{"5", item.getName(), "7"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }
    @Test
    public void whenAddCommentThenGetOne() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("itemOne", "desc"));
        tracker.add(new Item("itemTwo", "desc"));
        Item item = new Item("itemOne", "desc");
        tracker.add(item);
        Input input = new StubInput(new String[]{"6", item.getId(), "descOne", "7"});
        new StartUI(input, tracker, output).init();
        String[] comments = item.getComments();
        assertThat(comments[1], is("descOne"));
    }
    @Before
    public void loadOutPut() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutPut() {
        System.setOut(this.stdout);
    }
    @Test
    public void whenAddSomeItemsThenShowAllOfThem() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("itemOne", "desc");
        Item itemTwo = new Item("itemTwo", "desc");
        Item itemThree = new Item("itemThree", "desc");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        Input input = new StubInput(new String[]{"1", "7"});
        new StartUI(input, tracker, output).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("--------------- Меню. ----------------\n\n")
                                .append("    0 - Завести новую карту.\n")
                                .append("    1 - Показать все карты.\n")
                                .append("    2 - Заменить карту другой картой.\n")
                                .append("    3 - Удалить карту.\n")
                                .append("    4 - Найти карту по индетефикатору Id.\n")
                                .append("    5 - Найти карту по имени.\n")
                                .append("    6 - Добавить комментарий.\n")
                                .append("    7 - Покинуть программу.\n\n")
                                .append("Имя - itemOne\nid - " + itemOne.getId() + "\n")
                                .append("Имя - itemTwo\nid - " + itemTwo.getId() + "\n")
                                .append("Имя - itemThree\nid - " + itemThree.getId() + "\n")
                                .append("--------------- Меню. ----------------\n\n")
                                .append("    0 - Завести новую карту.\n")
                                .append("    1 - Показать все карты.\n")
                                .append("    2 - Заменить карту другой картой.\n")
                                .append("    3 - Удалить карту.\n")
                                .append("    4 - Найти карту по индетефикатору Id.\n")
                                .append("    5 - Найти карту по имени.\n")
                                .append("    6 - Добавить комментарий.\n")
                                .append("    7 - Покинуть программу.\n\n")
                                .toString()

                )
        );
    }
    @Test
    public void whenUserAddItemThenShowItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "7"});
        new StartUI(input, tracker, System.out::print).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("--------------- Меню. ----------------\n\n")
                                .append("    0 - Завести новую карту.\n")
                                .append("    1 - Показать все карты.\n")
                                .append("    2 - Заменить карту другой картой.\n")
                                .append("    3 - Удалить карту.\n")
                                .append("    4 - Найти карту по индетефикатору Id.\n")
                                .append("    5 - Найти карту по имени.\n")
                                .append("    6 - Добавить комментарий.\n")
                                .append("    7 - Покинуть программу.\n\n")
                                .append("------- Длобавление новой карты -------\n\n")
                                .append("Заведена новая карта Id №" + tracker.getItems().get(0).getId() + "\n\n")
                                .append("--------------- Меню. ----------------\n\n")
                                .append("    0 - Завести новую карту.\n")
                                .append("    1 - Показать все карты.\n")
                                .append("    2 - Заменить карту другой картой.\n")
                                .append("    3 - Удалить карту.\n")
                                .append("    4 - Найти карту по индетефикатору Id.\n")
                                .append("    5 - Найти карту по имени.\n")
                                .append("    6 - Добавить комментарий.\n")
                                .append("    7 - Покинуть программу.\n\n")
                                .toString()

                )
        );
    }
}