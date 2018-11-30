package ru.job4j.com;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import java.util.List;

public class BankTest {
    @Test
    public void whenAddSomeUsersAndAccountsThenGetAccountsOfUser1() {
        Bank bank = new Bank();
        UserBank user1 = new UserBank(1234, "Marat");
        UserBank user2 = new UserBank(2345, "Igor");
        UserBank user3 = new UserBank(3456, "Roma");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addUser(user3);
        Account account1 = new Account(10000, "00001");
        Account account2 = new Account(10000, "00002");
        Account account3 = new Account(10000, "00003");
        Account account4 = new Account(10000, "00004");
        Account account5 = new Account(10000, "00005");
        bank.addAccount(user1, account1);
        bank.addAccount(user1, account2);
        bank.addAccount(user1, account3);
        bank.addAccount(user2, account4);
        bank.addAccount(user3, account5);
        boolean expect = bank.getAccounts(user1).contains(account3);
        assertThat(expect, is(true));
    }

    @Test
    public void whenDeleteSomeUserThenHasNull() {
        Bank bank = new Bank();
        UserBank user1 = new UserBank(1234, "Marat");
        UserBank user2 = new UserBank(2345, "Igor");
        UserBank user3 = new UserBank(3456, "Roma");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addUser(user3);
        Account account1 = new Account(10000, "00001");
        Account account2 = new Account(10000, "00002");
        Account account3 = new Account(10000, "00003");
        Account account4 = new Account(10000, "00004");
        Account account5 = new Account(10000, "00005");
        bank.addAccount(user1, account1);
        bank.addAccount(user1, account2);
        bank.addAccount(user1, account3);
        bank.addAccount(user2, account4);
        bank.addAccount(user3, account5);
        bank.delete(user3);
        List<Account> result = null;
        assertThat(bank.getAccounts(user3), is(result));
    }
    @Test
    public void whenDeleteAccountThenHasNull() {
        Bank bank = new Bank();
        UserBank user1 = new UserBank(1234, "Marat");
        bank.addUser(user1);
        Account account1 = new Account(10000, "00001");
        Account account2 = new Account(10000, "00002");
        Account account3 = new Account(10000, "00003");
        bank.addAccount(user1, account1);
        bank.addAccount(user1, account2);
        bank.addAccount(user1, account3);
        bank.deleteAccount(user1, account3);
        boolean result = bank.getAccounts(user1).contains(account3);
        assertThat(result, is(false));
    }
    @Test
    public void whenAddSomeUsersAndAccountsThenToDoTransfer() {
        Bank bank = new Bank();
        UserBank user1 = new UserBank(1234, "Marat");
        UserBank user2 = new UserBank(2345, "Igor");
        UserBank user3 = new UserBank(3456, "Roma");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addUser(user3);
        Account account1 = new Account(10000, "00001");
        Account account2 = new Account(20000, "00002");
        Account account3 = new Account(30000, "00003");
        Account account4 = new Account(10000, "00004");
        Account account5 = new Account(10000, "00005");
        bank.addAccount(user1, account1);
        bank.addAccount(user1, account2);
        bank.addAccount(user1, account3);
        bank.addAccount(user2, account4);
        bank.addAccount(user3, account5);
        bank.transfer(user1, account2, user3, account5, 15000);
        int result = (int) bank.getAccounts(user3).get(0).getValues();
        assertThat(result, is(25000));
    }
}
