package com.masterclass.oldcontent.section08.challenges.groceryStore;

import java.util.Scanner;

public class GroceryStore {

    private static Scanner scan = new Scanner(System.in);
    private static GroceryArrayList groceryItems = new GroceryArrayList();

    public static void main(String[] args) {

        boolean quit = false;
        int option;

        System.out.println("---- Welcome to Grocery Store ----");
        showMenu();

        do {
            System.out.println("\nSelect your option: ");
            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    showMenu();
                    break;
                case 2:
                    AddItemBasket();
                    break;
                case 3:
                    showItemsBasket();
                    break;
                case 4:
                    searchItemBasker();
                    break;
                case 5:
                    modifyItemBasket();
                    break;
                case 6:
                    deleteItemBasket();
                    break;
                case 7:
                    quit = true;
                    System.out.println("Thank you for your presence, come back anytime!");
                    break;
            }


        } while (!quit);

        scan.close();
    }

    private static void showMenu() {
        System.out.println("(1) - Show menu.");
        System.out.println("(2) - Add item to basket.");
        System.out.println("(3) - Show the items in basket.");
        System.out.println("(4) - Search for a item in basket.");
        System.out.println("(5) - Modify an item in basket.");
        System.out.println("(6) - Delete an item from basket.");
        System.out.println("(7) - Quit store.");
    }

    private static void AddItemBasket(){
        System.out.println("Please inform the grocery item: ");
        groceryItems.addItem(scan.nextLine());
    }

    private static void showItemsBasket() {
        System.out.println("You have " + groceryItems.getItems().size() + " items in your basket.");
        groceryItems.printItems();
    }

    private static void searchItemBasker(){
        System.out.println("Please inform the grocery item for search: ");
        int position = groceryItems.findItemIndex(scan.nextLine());
        if (position >= 0) {
            System.out.println("The item " + groceryItems.getItems().get(position) + " was found in your basket.");
        } else {
            System.out.println("There is no such item in the basket.");
        }
    }

    private static void modifyItemBasket(){
        System.out.println("Please inform the grocery item that you want to exchange: ");
        String item = scan.nextLine();
        System.out.println("Please inform the grocery the new item: ");
        String newItem = scan.nextLine();
        groceryItems.modifyItem(item, newItem);
    }

    private static void deleteItemBasket(){
        System.out.println("Please inform the grocery item that you want to remove: ");
        groceryItems.removeItem(scan.nextLine());
    }
    
}
