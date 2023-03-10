package com.masterclass.oldcontent.section08.challenges.bankingApp;

import java.util.ArrayList;
import java.util.List;

public class Branch {

    private String branchName;
    private List<Costumer> costumers = new ArrayList<Costumer>();

    public Branch(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }

    public List<Costumer> getCostumers() {
        return costumers;
    }

    public boolean addCostumer(String costumerName, double amount) {
        Costumer existingCustomer = findCostumer(costumerName);
        if (existingCustomer == null) {
            if (amount >= 0) {
                costumers.add(new Costumer(costumerName, amount));
                return true;
            } else {
                System.out.println("Error: The transaction value needs to be positive.");
                return false;
            }

        } else {
            System.out.println("Costumer aleady exist.");
            return false;
        }
    }

    public boolean addTransition(double amount, String costumerName) {
        Costumer existingCustomer = findCostumer(costumerName);
        if (existingCustomer != null && amount > 0) {
            existingCustomer.addTransaction(amount);
            return true;
        } else {
            return false;
        }
    }

    public Costumer findCostumer(String name) {
        for (Costumer existingCostumer : costumers) {
            if (name.equalsIgnoreCase(existingCostumer.getName())) {
                return existingCostumer;
            }
        }

        return null;
    }

    public boolean removeCostumer(String costumerName) {
        Costumer existingCustomer = findCostumer(costumerName);
        if (existingCustomer != null) {
            costumers.remove(existingCustomer);
            return true;
        } else {
            System.out.println("Error: Could not find the customer.");
            return false;
        }

    }

}
