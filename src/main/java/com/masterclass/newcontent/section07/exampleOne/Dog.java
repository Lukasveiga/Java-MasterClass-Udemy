package com.masterclass.newcontent.section07.exampleOne;

public class Dog extends Animal{

    private final double tailLenght;

    public Dog(double tailLength, String type, double weight) {
        super(type, sizeDog(weight), weight);
        this.tailLenght = tailLength;
    }

    @Override
    public void makeNoise() {
        System.out.println(super.getType() + ": Barks");
    }

    public void grabToy(){
        System.out.println("Go get the toy!");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "tailLenght=" + tailLenght +
                "} " + super.toString();
    }

    private static String sizeDog(double weight){
        return weight < 15 ? "Small" : (weight  < 35 ? "Medium" : "Large");
    }
}
