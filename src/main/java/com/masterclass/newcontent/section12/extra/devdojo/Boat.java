package com.masterclass.newcontent.section12.extra.devdojo;

public class Boat implements Vehicle {

    private final String name;

    public Boat(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "name='" + name + '\'' +
                '}';
    }
}
