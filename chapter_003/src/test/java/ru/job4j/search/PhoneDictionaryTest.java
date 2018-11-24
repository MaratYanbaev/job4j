package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Marat", "Yanbaev", "534872", "Izhevsk")
        );
        List<Person> person = phones.find("Marat");
        assertThat(person.iterator().next().getSurname(), is("Yanbaev"));
    }

    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Marat", "Yanbaev", "534872", "Izhevsk")
        );
        List<Person> person = phones.find("5348");
        assertThat(person.iterator().next().getAddress(), is("Izhevsk"));
    }
}