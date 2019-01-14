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
        phones.add(
                new Person("Petr", "Ars", "534873", "Omsk")
        );
        List<Person> person = phones.find("Omsk");
        assertThat(person.iterator().next().getSurname(), is("Ars"));
    }

    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Marat", "Yanbaev", "53872", "Izhevsk")
        );
        phones.add(
                new Person("Petr", "Ars", "534873", "Omsk")
        );
        List<Person> person = phones.find("5348");
        assertThat(person.iterator().next().getAddress(), is("Omsk"));
    }
}