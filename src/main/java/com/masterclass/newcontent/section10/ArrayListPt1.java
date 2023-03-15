package com.masterclass.newcontent.section10;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPt1 {

    public static void main(String[] args) {

        List<GroceryItem> groceryArray = new ArrayList<>();
        groceryArray.add(new GroceryItem("apples", "PRODUCE", 5));
        groceryArray.add(new GroceryItem("orange", "PRODUCE", 6));

        for (GroceryItem g : groceryArray) {
            System.out.println(g.name() + ": " + g.count());
        }

    }

}

record GroceryItem(String name, String type, int count) {}
