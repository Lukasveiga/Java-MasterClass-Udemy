package com.masterclass.oldcontent.section07.challenges.room;

public class Main {

    public static void main(String[] args) {

        Wall[] walls = new Wall[4];
        walls[0] = new Wall("West");
        walls[1] = new Wall("East");
        walls[2] = new Wall("South");
        walls[3] = new Wall("North");

        Ceiling ceiling = new Ceiling(12, "Blue");

        Bed bed = new Bed("King-Size", 2, 2, 2, 1);

        Lamp lamp = new Lamp("Classic", false, 75);

        Bedroom bedroom = new Bedroom(bed, lamp, "Lukas", ceiling, walls);

        bedroom.makeBed();
        bedroom.getLamp().turnOn();
        
    }
    
}
