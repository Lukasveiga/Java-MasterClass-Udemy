package com.masterclass.oldcontent.section08.challenges.groceryStore;

import java.util.ArrayList;
import java.util.List;

public class GroceryArrayList {

    private List<String> items = new ArrayList<String>();

    public List<String> getItems() {
        return items;
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void printItems() {
        int count = 1;
        for (String item : items) {
            System.out.println(count + " - " + item);
            count++;
        }
    }

    public void modifyItem(String item, String newItem) {
        int position = findItemIndex(item);
        if (position >= 0) {
            items.set(position, newItem);
        } else {
            System.out.println("The item cannot be found.");
        }
        
    }

    public void removeItem(String item) {
        int position = findItemIndex(item);
        items.remove(position);
    }

    public int findItemIndex(String item){
        return items.indexOf(item);
    }

    
}
