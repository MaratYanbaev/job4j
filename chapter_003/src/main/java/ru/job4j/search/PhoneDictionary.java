package ru.job4j.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PhoneDictionary {
    private List<Person> person = new ArrayList<>();

    public void add(Person person) {
        this.person.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = person.stream().filter(p -> (p.getPhone().contains(key)
                || p.getAddress().contains(key)
                || p.getSurname().contains(key)
                || p.getName().contains(key))
        ).collect(Collectors.toList());
        return result;
    }
}
