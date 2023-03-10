package com.masterclass.oldcontent.section08.linkedList;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class TestLinkedList {

    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        LinkedList<String> namesList = new LinkedList<String>();

        namesList.add("Ana");
        namesList.add("Maria");
        namesList.add("Joao");
        namesList.add("Nat");

        ListIterator<String> iterator = namesList.listIterator();

        int action;
        boolean forward = true;
        boolean quit = false;

        do {
            System.out.println("Choice: 1: Next - 2: Previous - 3: Quit");
            action = scan.nextInt();

            switch(action) {
                case 1:
                    if (!forward) {
                        if (iterator.hasNext()){
                            iterator.next();
                        }
                        forward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    } else {
                        System.out.println("Reached end of list.");
                    }
                    break;
                case 2:
                    if (forward) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        forward = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println(iterator.previous());
                    } else {
                        System.out.println("Already at the start of list.");
                    }
                    break;
                case 3:
                    System.out.println("Quit program...");
                    quit = true;
                    break;
                default:
                    System.out.println("This option doesn't exist. Inform a valid option.");
                    break;
            }


        } while (!quit);


        scan.close();
    }
    
}
