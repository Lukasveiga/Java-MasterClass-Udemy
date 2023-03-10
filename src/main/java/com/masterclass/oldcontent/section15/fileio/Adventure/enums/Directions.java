package com.masterclass.oldcontent.section15.fileio.Adventure.enums;

public enum Directions {

    QUIT("Q", "QUIT"), NORTH("N", "NORTH"),
    SOUTH("S", "SOUTH"), WEST("W", "WSET"), EAST("E", "EAST");

    private final String direction;
    private final String description;

    private Directions(String direction, String description) {
        this.direction = direction;
        this.description = description;
    }

    public String getDirection() {
        return direction;
    }

    public String getDescription() {
        return description;
    }

}
