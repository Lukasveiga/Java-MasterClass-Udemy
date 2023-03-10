package com.masterclass.oldcontent.section09.challenges.savefilemedium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player lukas = Player.createWithDefaultWeapon("Lukas", 100, 250);
        System.out.println(lukas);
        saveObject(lukas);

        lukas.setWeapon("Hammer");
        System.out.println(lukas);
        
    }

    public static ArrayList<String> readValues() {
        Scanner scan = new Scanner(System.in);
        List<String> values = new ArrayList<String>();

        boolean quit = false;
        int index = 0;
        int choice;

        System.out.println("Choose:\n" +
                "1 - to enter a string\n" +
                "2 - to exit");

        while (!quit) {
            System.out.println("Choose a option: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter a string: ");
                    values.add(index, scan.nextLine());
                    index++;
                    break;
                case 2:
                    quit = true;
                    System.out.println("Exit ...");
                    break;
            }
        }
        scan.close();
        return (ArrayList<String>) values;
    }

    public static void saveObject(ISaveable objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device.");
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        List<String> values = readValues();
        objectToLoad.read(values);

    }
    
}
