package ru.job4j.analyze;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.analize.Analyze;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeTest {

    private Analyze.Info info;
    private Analyze analyze  = new Analyze();
    private List<Analyze.User> previous;
    private Map<String, Analyze.User> current;

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

        current = new HashMap<>();
        for (Analyze.User user: previous) {
            current.put(user.getId(), new Analyze.User(user));
        }
    }

    @Test
    public void deleteSomeElements() {
        current.remove(previous.get(1).getId());
        current.remove(previous.get(3).getId());

        info = analyze.diff(previous, current);

        assertThat(info.getDeleted(), is(2));
    }

    @Test
    public void changeSomeElements() {
        current.get(previous.get(0).getId()).newName("Zheny");
        current.get(previous.get(4).getId()).newName("Oly");

        info = analyze.diff(previous, current);

        assertThat(info.getChanged(), is(2));
    }

    @Test
    public void deleteChangeAddElementsThenResultGetChanges() {
        current.get(previous.get(4).getId()).newName("Oly");
        current.remove(previous.get(1).getId());
        current.remove(previous.get(2).getId());
        Analyze.User one = new Analyze.User("Fedy");
        Analyze.User two = new Analyze.User("Roma");
        Analyze.User free = new Analyze.User("Egor");
        current.put(one.getId(), one);
        current.put(two.getId(), two);
        current.put(free.getId(), free);

        info = analyze.diff(previous, current);

        assertThat(info.getDeleted(), is(2));
        assertThat(info.getChanged(), is(1));
        assertThat(info.getAdded(), is(3));
    }
}