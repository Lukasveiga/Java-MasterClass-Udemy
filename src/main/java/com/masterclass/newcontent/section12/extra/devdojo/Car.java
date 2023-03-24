package com.masterclass.newcontent.section12.extra.devdojo;

public class Car implements Vehicle {

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String getName() {

        return this.name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
