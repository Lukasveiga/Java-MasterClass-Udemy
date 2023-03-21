package com.masterclass.newcontent.section11.challenge.enums;

public enum Marker {

    BLACK_DOT("Black Dot"), GRAY_DOT("Gray Dot"), RED_DOT("Red Dot"),
    BLACK_STAR("Black Star"), GRAY_STAR("Gray Star"), RED_STAR("Red Star");

    private final String name;

    Marker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
