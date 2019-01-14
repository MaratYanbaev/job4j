package ru.job4j.com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserConvert {
    public static class User {
        private final String name;


        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{"
                    + "name='" + name + '\''
                    + '}';
        }
    }

    public List<User> convert(List<String> names) {
        return names.stream().map(User::new).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Petr", "Nick", "Ban");
        UserConvert users = new UserConvert();
        List<User> data = users.convert(names);
        data.forEach(System.out::println);
    }
}
