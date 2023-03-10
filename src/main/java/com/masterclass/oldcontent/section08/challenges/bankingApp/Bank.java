package com.masterclass.oldcontent.section08.challenges.bankingApp;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String bankName;
    private List<Branch> branches = new ArrayList<Branch>();

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public boolean addBranch(String branchName) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch == null) {
            branches.add(new Branch(branchName));
            return true;
        } else {
            return false;
        }
    }

    public void printCostumersList(String branchName) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            System.out.println("----- Costumers of " + branchName + " branch -----");
            int count = 1;
            for (Costumer costumer : existingBranch.getCostumers()) {
                System.out.println("Costumer #" + count + ": " + costumer.getName());
                count++;
            }
        } else {
            System.out.println("Error: the branch was not found.");
        }

    }

    public void printBranchs() {
        System.out.println("----- Active Branches -----");
        int count = 1;
        for (Branch branch : branches) {
            System.out.println("Branch #" + count + ": " + branch.getBranchName());
            count++;
        }
    }

    public void printCostumersAndTransactions(String branchName) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            System.out.println("----- Costumers of " + branchName + " branch -----");
            int count = 1;
            for (Costumer costumer : existingBranch.getCostumers()) {
                System.out.println("Costumer #" + count + ": " + costumer.getName());
                System.out.println("#Transactions: ");
                costumer.printTransactions();
                count++;
            }
        } else {

            System.out.println("Error: The branch was not found.");
        }

    }

    public Branch findBranch(String branchName) {
        for (Branch existingBranch : branches) {
            if (branchName.equalsIgnoreCase(existingBranch.getBranchName())) {
                return existingBranch;
            }
        }
        return null;
    }

    public boolean removeBranch(String branchName) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            branches.remove(existingBranch);
            return true;
        } else {
            System.out.println("Error: Could not find the branch.");
            return false;
        }
    }

}
