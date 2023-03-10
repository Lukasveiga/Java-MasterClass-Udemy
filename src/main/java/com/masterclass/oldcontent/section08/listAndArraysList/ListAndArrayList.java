package com.masterclass.oldcontent.section08.listAndArraysList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListAndArrayList {

    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        List<String> names = new ArrayList<String>();

        names.add("Lukas");
        names.add("Natalia");
        names.add("Marcos");
        names.add("Enda");

        System.out.println(names);
        System.out.println(names.get(0));

        names.set(0, "Lukas Veiga");
        System.out.println(names);
        System.out.println(names.get(0));

        names.remove(0);
        System.out.println(names);
        System.out.println(names.get(0));

        names.forEach((name) -> {
            System.out.println(name + " Ok");
        });

        System.out.println(names);

        String name = "Natalia";

        boolean exists = names.contains(name);
        if (exists) {
            System.out.println(name + " it's in the position " + (names.indexOf(name) + 1) + ".");
        } else {
            System.out.println(name + " it's not in the array.");
        }

        scan.close();
    }
    
    
}
