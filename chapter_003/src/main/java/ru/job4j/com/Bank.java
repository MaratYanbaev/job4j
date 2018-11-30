package ru.job4j.com;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Bank {

    private TreeMap<UserBank, ArrayList<Account>> treeMap = new TreeMap<>();
    //не выккидывает нул
    public void addUser(UserBank user) {
        this.treeMap.put(user, new ArrayList<>());
    }

    public void delete(UserBank user) {
        if (treeMap.containsKey(user)) {
            this.treeMap.remove(user);
        }
    }

    public void addAccount(UserBank user, Account account) {
        if (treeMap.containsKey(user)) {
            this.treeMap.get(user).add(account);
        }
    }

    private Account getActualAccount(UserBank user, Account account) {
        ArrayList<Account> list = this.treeMap.get(user);
        return list.get(list.indexOf(account));
    }

    public void deleteAccount(UserBank user, Account account) {
        if (treeMap.containsKey(user)) {
            this.treeMap.get(user).remove(account);
        }
    }

    public List<Account> getAccounts(UserBank user) {
        return this.treeMap.get(user);
    }

    public boolean transfer(UserBank user1, Account account1,
                            UserBank user2, Account account2, double amount) {

        return this.treeMap.get(user1).contains(account1)
                && this.treeMap.get(user2).contains(account2)
                && getActualAccount(user1, account1).transfer(
                getActualAccount(user2, account2), amount);
    }


    public String toString() {
        return "Bank {accounts = " + treeMap + "}";
    }
}