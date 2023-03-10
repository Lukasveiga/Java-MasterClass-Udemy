package com.masterclass.newcontent.section07.exampleOne;

public class Dog extends Animal{

    private double tailLenght;

    public Dog(double tailLength, String type, double size, double weight) {
        super(type, size, weight);
        this.tailLenght = tailLength;
    }

    @Override
    public void makeNoise() {
        System.out.println(super.getType() + ": Barks");
    }
}
