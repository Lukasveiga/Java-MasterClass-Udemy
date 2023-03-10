package com.masterclass.newcontent.section07.exampleOne;

public abstract class Animal {

    private String type;
    private double size;
    private double weight;

    public Animal(String type, double size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public void move(double speed){
        System.out.println(this.type + " moves " + speed + " m/s.");
    }

    public void makeNoise(){
        System.out.println(this.type + " makes some kind of noise");
    }

    public String getType() {
        return type;
    }

    public double getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }
}
