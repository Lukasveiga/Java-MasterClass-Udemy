package com.masterclass.oldcontent.section13.Adventure;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private final String description;
    private final Map<String, Integer> exits;

    public Location(String description, Map<String, Integer> exits) {
        this.description = description;
        if(exits != null) {
            this.exits = new HashMap<String, Integer>(exits);
        } else {
            this.exits = new HashMap<String, Integer>();
        }
        this.exits.put("Q",0);
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }

    
}
