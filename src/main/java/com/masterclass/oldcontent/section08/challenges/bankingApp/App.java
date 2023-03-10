package com.masterclass.oldcontent.section08.challenges.bankingApp;

import java.util.Scanner;

public class App {

    private static Scanner scan = new Scanner(System.in);
    private static Bank bank = new Bank("Izau");

    public static void main(String[] args) {

        boolean quit = false;
        int option;

        System.out.println("Welcome to " + bank.getBankName() + "!");
        showOptions();

        do {
            System.out.println("Choose a option: (8 - Show the options)");
            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 0:
                    System.out.println("Thank you for choosing our services!");
                    quit = true;
                    break;
                case 1:
                    addNewBranchToBank();
                    break;
                case 2:
                    addNewCostumerToBranch();
                    break;
                case 3:
                    newTransaction();
                    break;
                case 4:
                    bank.printBranchs();
                    break;
                case 5:
                    System.out.println("Show the costumes transactions? (Yes/No)");
                    String choice = scan.nextLine();
                    if (choice.equalsIgnoreCase("no")) {
                        displayCostumersBranch();
                    } else if (choice.equalsIgnoreCase("yes")) {
                        displayCostumersAndTransactionsBranch();
                    } else {
                        System.out.println("Error: Option not found.");
                    }
                    break;
                case 6:
                    removeCostumer();
                    break;
                case 7:
                    System.out.println(
                            "WARNING: Branch removal will remove all clients on that branch. Are you sure about that? (Yes/No)");
                    if (scan.nextLine().equalsIgnoreCase("yes")) {
                        removeBranch();
                    }
                    break;
                case 8:
                    showOptions();
                    break;
            }

        } while (!quit);

        scan.close();

    }

    private static void addNewBranchToBank() {
        System.out.println("Select a name for the new branch: ");
        String branchName = scan.nextLine();
        if (bank.addBranch(branchName)) {
            System.out.println(branchName + " was added successfully!");
        } else {
            System.out.println("Error: The branch " + branchName + " was not added.");
        }

    }

    // Changed method to de class Branch
    private static void addNewCostumerToBranch() {
        System.out.println("Inform the name of branch that you to add the new costumer: ");
        String branchName = scan.nextLine();
        if (bank.findBranch(branchName) != null) {

            System.out.println("Infom the name of the new costumer: ");
            String name = scan.nextLine();

            System.out.println("Please, informe the initial transaction for costumer " + name + ": ");
            double initialAmount = scan.nextDouble();

            if (bank.findBranch(branchName).addCostumer(name, initialAmount)) {
                System.out.println("The costumer " + name + " was added successfully!");
            } else {
                System.out.println("Error: The costumer " + name + " was not added.");
            }
        } else {
            System.out.println("Error: Could not find the branch.");
        }
    }

    private static void newTransaction() {
        System.out.println("Inform the name of branch that have the costumer: ");
        String branchName = scan.nextLine();

        if (bank.findBranch(branchName) != null) {
            System.out.println("Infom the name of the costumer to do the transaction: ");
            String costumerName = scan.nextLine();

            if (bank.findBranch(branchName).findCostumer(costumerName) != null) {
                System.out.println("Informe de value of the transaction: ");
                double transaction = scan.nextDouble();

                bank.findBranch(branchName).findCostumer(costumerName).addTransaction(transaction);
            } else {
                System.out.println("Error: The costumer was not found.");
            }
        } else {
            System.out.println("Error: The branch was not found.");
        }
    }

    private static void displayCostumersBranch() {
        System.out.println("Inform the name of branch that you want to see the costumers list: ");
        bank.printCostumersList(scan.nextLine());
    }

    private static void displayCostumersAndTransactionsBranch() {
        System.out.println("Inform the name of branch that you want to see the costumers list: ");
        bank.printCostumersAndTransactions(scan.nextLine());
    }

    private static void removeCostumer() {
        System.out.println("Inform the name of branch that have the costumer: ");
        String branchName = scan.nextLine();

        if (bank.findBranch(branchName) != null) {
            System.out.println("Infom the name of the costumer to do the transaction: ");
            String costumerName = scan.nextLine();

            if (bank.findBranch(branchName).removeCostumer(costumerName)) {
                System.out.println("The costumer has been removed.");
            } else {
                System.out.println("Unable to remove.");
            }
        } else {

            System.out.println("Error: The branch was not found.");
        }
    }

    private static void removeBranch() {
        System.out.println("Inform the name of branch that have the costumer: ");

        if (bank.removeBranch(scan.nextLine())) {
            System.out.println("The branch has been removed.");
        } else {
            System.out.println("Unable to remove.");
        }
    }

    private static void showOptions() {
        System.out.println("(0) - Quit.\n" +
                "(1) - Add a new branch.\n" +
                "(2) - Add new Costumer in a specific branch.\n" +
                "(3) - Do a transaction.\n" +
                "(4) - Show active branches.\n" +
                "(5) - Display the costumers of a selected branch.\n" +
                "(6) - Remove a costumer.\n" +
                "(7) - Remove a branch.\n" +
                "(8) - Show the optins.");

    }

}
