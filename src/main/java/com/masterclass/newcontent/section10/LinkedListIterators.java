package com.masterclass.newcontent.section10;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListIterators {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>(Arrays.asList(
                "Lukas", "João", "Pedro", "Julia", "Rebeca"
        ));

        var iterator =  list.listIterator();

        while (iterator.hasNext()){
            if (iterator.next().equalsIgnoreCase("Pedro")){
                iterator.remove();
                iterator.add("Cássio");
            }
        }

        System.out.println(list);
    }
}
