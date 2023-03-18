package com.masterclass.newcontent.section10.challenges.challengeLinkedList;

import java.util.*;

public class App {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        boolean quit = false;
        boolean foward = true;
        LinkedList<Town> list = TownList.createListOfTowns();
        var iterator = list.listIterator();

        while (!quit) {

            showMenu();
            String answer = scan.nextLine();

            switch (answer.toLowerCase().charAt(0)) {
                case 'f' -> {
                    System.out.println("Next Town: ");
                    if (!foward) {
                        foward = true;
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                    }

                    if (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                    else {
                        System.out.println("You reach the end of the list.");
                    }
                }
                case 'b' -> {
                    System.out.println("Previous Town: ");
                    if (foward) {
                        foward = false;
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                    }

                    if (iterator.hasPrevious()) {
                        System.out.println(iterator.previous());
                    }
                    else {
                        System.out.println("You reach the start of the list.");
                    }
                }
                case 'l' -> System.out.println(list);
                case 'q' -> {
                    System.out.println("Closing the program...");
                    quit = true;
                }
            }

        }

    }

    private static void showMenu() {
        System.out.println("""
                                   Available action (select word or letter):
                                   (F)orward
                                   (B)ackward
                                   (L)ist places
                                   (Q)uit""");
    }


}
