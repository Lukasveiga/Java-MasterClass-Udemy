package com.masterclass.oldcontent.section07.exercises.composition;

public class Bedroom {

    private String name;
    private Wall[] walls = new Wall[3];
    private Ceiling ceiling;
    private Bed bed;
    private Lamp lamp;

    public Bedroom(String name, Wall[] walls, Ceiling ceiling, Bed bed, Lamp lamp) {
        this.name = name;
        this.walls = walls;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }

    public void makeBed() {

        System.out.println("Bedroom -> Making bed | ");
        bed.make();
    }

    public Lamp getLamp() {
        return lamp;
    }

    public String getName() {
        return name;
    }

    public Wall getWallAtIndex(int index) {
        return walls[index];
    }

    public Ceiling getCeiling() {
        return ceiling;
    }

    public Bed getBed() {
        return bed;
    }

    

}
