package com.masterclass.newcontent.section11.challenge.enums;

public enum GeometryType {

    POINT("Point"), LINE("Line"), PLYGON("Polygon");

    private final String name;

    GeometryType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
