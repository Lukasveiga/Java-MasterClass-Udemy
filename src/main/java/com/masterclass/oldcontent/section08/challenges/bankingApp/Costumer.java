package com.masterclass.oldcontent.section08.challenges.bankingApp;

import java.util.ArrayList;
import java.util.List;

public class Costumer {

    private String name;
    private List<Double> transactions = new ArrayList<Double>();

    public Costumer() {

    }

    public Costumer(String name, double amount) {
        this.name = name;
        this.transactions.add(amount);
    }

    public Costumer(String name, List<Double> transactions) {
        this.name = name;
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }

    public void addTransaction(double value) {
        this.transactions.add(value);
    }

    public void printTransactions() {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println("#" + (i + 1) + ": R$ " + transactions.get(i));
        }
    }

}
