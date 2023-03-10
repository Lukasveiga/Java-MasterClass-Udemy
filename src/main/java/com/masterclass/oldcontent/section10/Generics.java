package com.masterclass.oldcontent.section10;

import java.util.ArrayList;

public class Generics {

    public static void main(String[] args) {
        
        ArrayList<Integer> items = new ArrayList<>();

        for (int i = 1; i < 6; i++) {
            items.add(i);   
        }

        printDoubled(items);
    }

    static void printDoubled(ArrayList<Integer> items) {
        try{
            for (Object i : items) {
                System.out.println((Integer) i * 2);    
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }
    
}
