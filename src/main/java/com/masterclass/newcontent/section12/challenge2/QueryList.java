package com.masterclass.newcontent.section12.challenge2;

import java.util.ArrayList;
import java.util.List;

public class QueryList {
    public static <T extends Student> List<T> getMatches(List<T> items, String field, String value){

        List<T> matches = new ArrayList<>();
        for (var item : items){
            if (item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }
}
