package ru.job4j.list;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenHasListThenConvert2HashMap() {
        UserConvert convert = new UserConvert();
        List<User> user = List.of(
                new User(1, "Marat"), new User(2, "Petr"), new User(3, "Oleg")
        );
        HashMap<Integer, User> result = convert.process(user);
        assertThat(result.get(3).getName(), is("Oleg"));
    }
}
