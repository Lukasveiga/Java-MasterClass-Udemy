package com.masterclass.newcontent.section11.challenge.enums;

public enum Usage {

    ENTERTAIMENT("Entertainment"), GOVERNMENT("Government"), SPORTS("Sports");

    private final String name;

    Usage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
