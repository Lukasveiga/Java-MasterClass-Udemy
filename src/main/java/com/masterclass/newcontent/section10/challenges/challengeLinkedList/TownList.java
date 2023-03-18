package com.masterclass.newcontent.section10.challenges.challengeLinkedList;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class TownList {

    private static final Scanner scan = new Scanner(System.in);

    @Contract(" -> new")
    public static @NotNull LinkedList<Town> createListOfTowns() {

        System.out.println("Inform the numbers of towns to register in the list: ");
        int numberOfTowns = scan.nextInt();

        ArrayList<Town> townsList = new ArrayList<>(numberOfTowns);

        scan.nextLine();

        System.out.println("Now inform the refence Town: ");
        Town townReference = Town.createReferencePoint(scan.nextLine());

        townsList.add(townReference);

        for (int i = 0; i < (numberOfTowns - 1); i++) {

            int flag;

            do {

                System.out.println("Inform the name of the next town: ");
                String name = scan.nextLine();

                Town town = new Town(name);

                flag = searchTownByName(townsList, town.getName());

                if (flag < 0) {

                    System.out.println("Inform the distance of this town for the reference (" + townReference.getName() + "):");
                    double distance = scan.nextDouble();

                    town.setDistanceReferencePoint(distance);

                    townsList.add(town);
                }
                else {
                    System.out.println("This town already is into list.");
                }

            } while (flag >= 0);


            scan.nextLine();

        }

        Collections.sort(townsList);

        return new LinkedList<>(townsList);
    }

    private static int searchTownByName(@NotNull ArrayList<Town> townList, String name) {

        int index = -1;

        for (Town t : townList) {
            if (t.getName().equalsIgnoreCase(name)) {
                index = townList.indexOf(t);
                break;
            }
        }

        return index;
    }
}
