package com.masterclass.oldcontent.section08.autoboxing;

import java.util.ArrayList;
import java.util.List;

public class PrimitiveToClassInteger {

    public static void main(String[] args) {
        
        List<Integer> integers = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            integers.add(Integer.valueOf(i));    // --> Autoboxing: primitive type int transformed into Integer class.
        }

        for(int i = 0; i < 10; i++) {
            System.out.println(i + " --> " + integers.get(i).intValue());  // --> Unboxing: Integer class transformed into primite type int.
        }
    }
    
}
