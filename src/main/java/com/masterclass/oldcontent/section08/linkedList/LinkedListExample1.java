package com.masterclass.oldcontent.section08.linkedList;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedListExample1 {

    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<String>();

        addInOrder(cities, "João Pessoa");
        addInOrder(cities, "Campina Grande");
        addInOrder(cities, "São Paulo");
        addInOrder(cities, "Curitiba");
        addInOrder(cities, "Manaus");   

        printList(cities);

        visit(cities, scan);

        scan.close();
    }

    private static void printList(LinkedList<String> linkedList) {
        ListIterator<String> iterator = linkedList.listIterator();

        while (iterator.hasNext()) {
            System.out.println("City: " + iterator.next());
        }
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> iterator = linkedList.listIterator();

        while (iterator.hasNext()) {
            int comparison = iterator.next().compareTo(newCity);
            // if compareTo return 0 the string are equal;
            // if compareTo return a value less the 0 the string is less than the other
            // string
            // if compareTo return a value greater than 0 the string is greater than the
            // other string.
            // Ex. ("a").compareTo("b") -> return -1;
            // Ex. ("b").compareTo("a") -> return 1;
            // ex, ("a").comperaTo("a") -> return 0;
            if (comparison == 0) {
                System.out.println(newCity + " already included as a destination.");
                return false;
            } else if (comparison > 0) {
                iterator.previous();
                iterator.add(newCity);
                return true;
            } else if (comparison < 0) {

            }
        }
        iterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList<String> cities, Scanner scan) {

        boolean goingFoward = true;
        boolean quit = false;

        ListIterator<String> iterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in the intenrary.");
        } else {
            System.out.println("Now visiting " + iterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scan.nextInt();
            scan.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Holiday (Vacation) over.");
                    quit = true;
                    break;
                case 1:
                    if (!goingFoward) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        goingFoward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Now visiting " + iterator.next());
                    } else {
                        System.out.println("Reached the end of list.");
                        goingFoward = false;
                    }
                    break;
                case 2:
                    if (goingFoward) {
                        if (iterator.hasNext()) {
                            iterator.previous();
                        }
                        goingFoward = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Now visiting " + iterator.previous());
                    } else {
                        System.out.println("We are at the start of the list.");
                        goingFoward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;

            }
        }

    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - Quit.\n" +
                "1 - Go next city\n" +
                "2 - Go to previous city\n" +
                "3 - Print menu options.");

    }

}
