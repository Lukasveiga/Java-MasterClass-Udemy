package com.masterclass.oldcontent.section08.challenges.mobilePhone;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {

    private String myNumber;
    private List<Contact> contacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contacts = new ArrayList<Contact>();
    }

    public String getMyNumber() {
        return myNumber;
    }

    public boolean addContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false;

        } else {
            contacts.add(contact);
            return true;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        if(oldContact != null && newContact != null){
            int foundPosition = findContact(oldContact);
            if(foundPosition < 0) {
                return false;
            } else if(findContact(newContact.getName()) >= 0) {
                System.out.println("Contact with name " + newContact.getName() + " already exists. Update was not successful.");
                return false;
            } else {
                this.contacts.set(foundPosition, newContact);
                return true;
            }
        } else {
                return false;
            }
        
    }

    public String queryName(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        } else {
            return null;
        }
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if (position >= 0) {
            return this.contacts.get(position);
        } else {
            return null;
        }
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            return false;
        } else {
            this.contacts.remove(foundPosition);
            return true;
        }
    }

    private int findContact(Contact contact) {
        if (contact != null) {
            return this.contacts.indexOf(contact);
        } else {
            return -1;
        }
        
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.contacts.size(); i++) {
            Contact contact = this.contacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public void printContacts(){
        System.out.println("Contact List: ");
        for (Contact contact: this.contacts) {
            if (contact != null) {
                System.out.println("Name: " + contact.getName() + " - Phone Number: " + contact.getPhoneNumber());
            }
        }
    }

    
}
