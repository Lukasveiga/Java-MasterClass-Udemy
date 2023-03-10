package com.masterclass.oldcontent.section13.maptest;

import java.util.HashMap;
import java.util.Map;

public class MyMap {

    public static void main(String[] args) {

        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "a compiled high level");
        languages.put("Python", "an interpreted high level");
        languages.put("Algol", "an algorithmic linguage");

        System.out.println(languages.get("Java"));
    }
    
}
