package ru.job4j.list;

public class UserCom implements Comparable<UserCom> {
    private String name;
    private Integer age;

    public UserCom(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(UserCom o) {
        return this.age.compareTo(o.age) == 0 ? this.name.compareTo(o.name) : this.age.compareTo(o.age);
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
