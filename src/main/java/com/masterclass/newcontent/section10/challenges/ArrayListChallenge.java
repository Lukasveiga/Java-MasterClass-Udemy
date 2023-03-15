package com.masterclass.newcontent.section10.challenges;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ArrayListChallenge {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        boolean flag = false;
        List<String> groceryList = new ArrayList<>();

        while (!flag) {
            showMenu();

            int awnser = scan.nextInt();
            scan.nextLine();

            switch (awnser) {
                case 0 -> {
                    flag = true;
                    System.out.println("Closing the program...");
                    scan.close();
                }
                case 1 -> addItems(groceryList);
                case 2 -> removeItem(groceryList);
            }
        }

    }

    private static void showMenu() {
        System.out.println(
                """
                        Available actions:
                        0 - to shutdown
                        1 - to add item(s) to list (comma delimited list)
                        2 - to remove any items (comma delimited list)
                        Enter a number for which action you want to do:"""
        );
    }

    private static void addItems(List<String> groceryList) {
        System.out.println("Inform the item to add into the list:");
        String[] items = scan.nextLine().toLowerCase().split(",");

        for (String s : items) {
            s = s.toLowerCase().trim();
            if (groceryList.contains(s)) {
                System.out.println("The list already contains this item: " + s);

            }
            else {
                groceryList.add(s);
                System.out.println("List updated successfully: Added " + s);
            }
        }

        groceryList.sort(Comparator.naturalOrder());
        System.out.println("Current list: " + groceryList);
    }

    private static void removeItem(List<String> groceryList) {
        System.out.println("Inform the item(s) to remove to the list:");
        String[] items = scan.nextLine().toLowerCase().split(",");

        for (String s : items) {
            s = s.toLowerCase().trim();
            if (groceryList.remove(s)) {
                System.out.println("The item was removed successfully: " + s);
            }
            else {
                System.out.println("Wasn't possible to find the item into the list: " + s);
            }
        }

        groceryList.sort(Comparator.naturalOrder());
        System.out.println("Current list: " + groceryList);
    }

}
