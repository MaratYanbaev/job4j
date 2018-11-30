package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.getItems().get(0), is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2");
        tracker.replace(previous.getId(), next);
        ArrayList<Item> items = tracker.getItems();
        assertThat(items.contains(next), is(true));
    }
    @Test
    public void whenAddNewItemThenFindNecessaryItemByName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "firstDescription");
        Item second = new Item("test2", "secondDescription");
        Item third = new Item("test3", "thirdDescription");
        Item fourth = new Item("test2", "fourthDescription");
        Item fifth = new Item("test2", "fifthDescription");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        tracker.add(fifth);
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(second);
        expected.add(fourth);
        expected.add(fifth);
        ArrayList<Item> result = tracker.findByName("test2");
        assertEquals(expected, result);
    }
    @Test
    public void whenDeleteSecondNameThenReturnNull() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "firstDescription");
        Item second = new Item("test2", "secondDescription");
        Item third = new Item("test3", "thirdDescription");
        Item fourth = new Item("test4", "fourthDescription");
        Item fifth = new Item("test5", "fifthDescription");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(fourth);
        tracker.add(fifth);
        tracker.delete(second.getId());
        assertThat(tracker.getItems().get(1).getName(), is(third.getName()));
    }
}
