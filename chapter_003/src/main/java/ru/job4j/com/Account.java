package ru.job4j.com;


public class Account {

    private double values;
    private String requisites;

    public Account(double values, String requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    public double getValues() {
        return this.values;
    }


    public String getReqs() {
        return this.requisites;
    }


    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    public String toString() {
        return String.format("Account {values = %f, reqs=' %s '}", values, requisites);
    }

    public boolean equals(Object o) {
        Account account = (Account) o;
        boolean u = false;
        if (this == o) {
            u = this.requisites.equals(account.requisites);
        }
        return u;




        /*if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return this.reqs.equals(account.reqs);*/
    }

    public int hashCode() {
        return this.requisites.hashCode();
    }
}