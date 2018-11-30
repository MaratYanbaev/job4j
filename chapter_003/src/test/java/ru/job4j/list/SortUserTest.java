package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SortUserTest {
    @Test
    public void whenHasListThenTreeSetSortByAge() {
        SortUser su = new SortUser();
        List<UserCom> user = List.of(
                new UserCom("Ivan", 27),
                new UserCom("Marat", 33),
                new UserCom("Petr", 35),
                new UserCom("Azat", 20),
                new UserCom("Avatar", 20)
        );
        Set<UserCom> sortUser = su.sort(user);
        UserCom[] i = new UserCom[5];
        UserCom[] result = sortUser.toArray(i);
        assertThat(result[0].getName(), is("Avatar"));
    }

    @Test
    public void whenHasListThenSortListByNameLength() {
        SortUser su = new SortUser();
        List<UserCom> user = List.of(
                new UserCom("Marat1", 33),
                new UserCom("Petr", 35),
                new UserCom("Ivan12345", 27),
                new UserCom("Azat1", 20),
                new UserCom("Avatar12", 20)
        );
        user = su.sortNameLength(user);
        assertThat(user.get(0).getName(), is("Petr"));
    }

    @Test
    public void whenHasListThenListSortByNameOrAge() {
        SortUser su = new SortUser();
        List<UserCom> user = List.of(
                new UserCom("Ivan", 27),
                new UserCom("Marat", 33),
                new UserCom("Azat", 20),
                new UserCom("Ivan", 35),
                new UserCom("Avatar", 20)
        );
        user = su.sortByAllFields(user);
        assertThat(user.get(2).getAge(), is(27));
    }
}
