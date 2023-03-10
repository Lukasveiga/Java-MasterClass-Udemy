package com.masterclass.oldcontent.section13.setAndHashSet;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        set.add("lemur");
        set.add("orangatang");
        set.add("spider monkey");
        set.add("silverback gorilla");

        set.remove("lemur");

        System.out.println(set);

        System.out.println(set.size());
    }

}
