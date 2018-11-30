package ru.job4j.list;

import java.util.*;
import java.util.stream.Collectors;

public class SortUser {

    public Set<UserCom> sort(List<UserCom> user) {
        return new TreeSet<>(user);
    }

    public List<UserCom> sortNameLength(List<UserCom> user) {
        return user.stream().
                sorted(Comparator.comparingInt(o -> o.getName().length())).
                collect(Collectors.toList());
    }

    public List<UserCom> sortByAllFields(List<UserCom> user) {
       return user.stream().
               sorted(
                       Comparator.comparing(UserCom::getName).
                               thenComparingInt(UserCom::getAge)
               ).
               collect(Collectors.toList());
    }


}
