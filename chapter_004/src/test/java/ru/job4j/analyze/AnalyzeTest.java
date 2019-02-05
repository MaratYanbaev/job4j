package ru.job4j.analyze;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.analize.Analyze;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

public class AnalyzeTest {

    private Analyze.Info info;
    private Analyze analyze  = new Analyze();
    private List<Analyze.User> previous;
    private List<Analyze.User> current;

    @Before
    public void setUp() {
        previous = new ArrayList<>();
        Analyze.User one = new Analyze.User("Marat");
        Analyze.User two = new Analyze.User("Petr");
        Analyze.User free = new Analyze.User("Azat");
        Analyze.User four = new Analyze.User("Sasha");
        Analyze.User five = new Analyze.User("Oleg");
        previous.add(one);
        previous.add(two);
        previous.add(free);
        previous.add(four);
        previous.add(five);

        current = new ArrayList<>();
        for (Analyze.User user: previous) {
            current.add(new Analyze.User(user));
        }
    }

    @Test
    public void deleteSomeElements() {
        current.remove(1);
        current.remove(3);
        info = analyze.diff(previous, current);

        assertThat(info.getDeleted(), is(2));
    }

    @Test
    public void changeSomeElements() {
        current.get(0).newName("Zheny");
        current.get(4).newName("Oly");
        info = analyze.diff(previous, current);

        assertThat(info.getChanged(), is(2));
    }

    @Test
    public void deleteChangeAddElementsThenResultGetChanges() {
        current.get(4).newName("Oly");
        current.remove(1);
        current.remove(2);
        current.add(new Analyze.User("Fedy"));
        current.add(new Analyze.User("Roma"));
        current.add(new Analyze.User("Egor"));
        info = analyze.diff(previous, current);

        assertThat(info.getDeleted(), is(2));
        assertThat(info.getChanged(), is(1));
        assertThat(info.getAdded(), is(3));
    }
}