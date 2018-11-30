package ru.job4j.list;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        /*HashMap<Integer, User> map = new HashMap<>();
        for (User user: list) {
            map.put(user.getId(), user);
        }*/
        return list.stream().collect(Collectors.toMap(User::getId, user -> user, this::throwIllegalArgumentException, HashMap::new));
    }

    private <U> U throwIllegalArgumentException(U u, U u1) {
        return null;
    }
}
