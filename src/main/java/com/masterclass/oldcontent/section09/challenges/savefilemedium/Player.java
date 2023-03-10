package com.masterclass.oldcontent.section09.challenges.savefilemedium;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable{

    private String name;
    private String weapon;
    private int hitPoints;
    private int strenght;


    public Player(String name, String weapon, int hitPoints, int strenght) {
        this.name = name;
        this.weapon = "Sword";
        this.hitPoints = hitPoints;
        this.strenght = strenght;
    }

    public static Player createWithDefaultWeapon(String name, int hitPoints, int strenght) {
        return new Player(name, "Sword", hitPoints, strenght);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    

    @Override
    public String toString() {
        return "Player [Name: " + name + ", Weapon: " + weapon + ", Hit Points: " + hitPoints + ", Strenght: " + strenght
                + "]";
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0, this.name);
        values.add(1, this.weapon);
        values.add(2, String.valueOf(this.hitPoints));
        values.add(3, String.valueOf(this.strenght));
        return values;
    }
    @Override
    public void read(List<String> saveable) {
        try{
            if (saveable != null && !saveable.isEmpty()) {
                this.name = saveable.get(0);
                this.weapon = saveable.get(1);
                this.hitPoints = Integer.parseInt(saveable.get(2));
                this.strenght = Integer.parseInt(saveable.get(3));
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e + ": The list must have all 4 fields filled.");
        } 
    }
    
}
