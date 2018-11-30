package ru.job4j.com;

import java.util.Objects;

public class UserBank implements Comparable<UserBank> {
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserBank userBank = (UserBank) o;
        return passport.equals(userBank.passport)
                && Objects.equals(name, userBank.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport, name);
    }

    private Integer passport;
    private String name;

    public UserBank(int passport, String name) {
        this.passport = passport;
        this.name = name;
    }

    public int getPassport() {
        return passport;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(UserBank o) {
        return o.passport.compareTo(this.passport);
    }
}
