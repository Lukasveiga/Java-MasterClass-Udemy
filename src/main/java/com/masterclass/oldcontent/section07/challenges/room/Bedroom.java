package com.masterclass.oldcontent.section07.challenges.room;

public class Bedroom {

    private Bed bed;
    private Lamp lamp;
    private String name;
    private Ceiling ceiling;
    private Wall[] walls = new Wall[3];

    public Bedroom(Bed bed, Lamp lamp, String name, Ceiling ceiling, Wall[] walls) {
        this.bed = bed;
        this.lamp = lamp;
        this.name = name;
        this.ceiling = ceiling;
        this.walls = walls;
    }

    
    public Lamp getLamp() {

        return this.lamp;
    }
    
    public void makeBed() {

        System.out.println("Bedroom -> Making bed.");
        bed.make();
    }


    public Bed getBed() {
        return bed;
    }


    public String getName() {
        return name;
    }


    public Ceiling getCeiling() {
        return ceiling;
    }


    public Wall[] getWalls() {
        return walls;
    }

    

}
