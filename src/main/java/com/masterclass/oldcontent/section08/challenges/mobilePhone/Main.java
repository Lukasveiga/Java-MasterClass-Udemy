package com.masterclass.oldcontent.section08.challenges.mobilePhone;

import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("(83) 9 98132238");
    public static void main(String[] args) {

        boolean quit = false;
        int action;

        startPhone();
        printActions();

        do {
            System.out.println("\nEnter action: (6 to show available actions)");
            action = scan.nextInt();
            scan.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Shutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
                
                
            }
        } while (!quit);    
        
    }

    private static void addNewContact(){
        Contact contact = new Contact();

        System.out.println("Enter with new contact name: ");
        contact.setName(scan.nextLine());

        System.out.println("Enter with new contact prhone number: ");
        contact.setPhoneNumber(scan.nextLine());

        if(mobilePhone.addContact(contact)) {
            System.out.println("New contact added: Name -> " + contact.getName() + ", Phone Number -> " + contact.getPhoneNumber());
        } else {
            System.out.println("Contact " + contact.getName() + " is already on file.");
        }
    }

    private static void updateContact(){
        System.out.println("Enter existing contact name: ");
        Contact existingContact = mobilePhone.queryContact(scan.nextLine());
        if (existingContact == null) {
            System.out.println("Contact not found.");
        } else {
            Contact newContact = new Contact();

            System.out.println("Enter with new contact name: ");
            newContact.setName(scan.nextLine());

            System.out.println("Enter with new contact phone number: ");
            newContact.setPhoneNumber(scan.nextLine());

            if (mobilePhone.updateContact(existingContact, newContact)) {
                System.out.println("Contact was updated successfully.");
            } else {
                System.out.println("Error updating contact.");
            }
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        Contact existingContact = mobilePhone.queryContact(scan.nextLine());
        if (existingContact == null) {
            System.out.println("Contact not found.");
        } else {
            if (mobilePhone.removeContact(existingContact)) {
                System.out.println("Successfully deleted.");
            } else {
                System.out.println("Error deleting contact.");
            }
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        Contact existingContact = mobilePhone.queryContact(scan.nextLine());
        if (existingContact == null) {
            System.out.println("Contact not found.");
        } else {
            
            System.out.println("Name -> " + existingContact.getName() + ", Phone Number -> " + existingContact.getPhoneNumber());
        }
    }


    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("(0) - to shutdown\n" + 
                           "(1) - to print contacts\n" +
                           "(2) - to add a new contact\n" +
                           "(3) - to update an existing contacts\n" +
                           "(4) - to remove an existing contact\n" +
                           "(5) - query if an existing contact\n" + 
                           "(6) - to print a list of available actions");
        System.out.println("Choose your action: ");
    }


    
}
