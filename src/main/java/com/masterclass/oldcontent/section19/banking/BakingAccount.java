package com.masterclass.oldcontent.section19.banking;

public class BakingAccount {

    private final String firstName;
    private final String lastName;
    private double balance;

    public BakingAccount(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = 0;
    }

    public boolean deposit(double amount) {
        if (amount < 0) {
            return false;
        } else {
            this.balance += amount;
            return true;
        }
    }

    public boolean withdraw(double amount, boolean afterMidnight) {
       if (amount < 0) {
           return false;
       } else if (amount > this.balance) {
           return false;
       } else if (afterMidnight){
           throw new IllegalArgumentException("Can't be withdraw after midnight");
       } else {
           this.balance -= amount;
           return true;
       }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }
}
