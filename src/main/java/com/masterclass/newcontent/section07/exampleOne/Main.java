package com.masterclass.newcontent.section07.exampleOne;

public class Main {

    public static void main(String[] args) {

        Animal dog = new Dog(0.5, "Beagle", 17);
        dog.move(15);
        dog.makeNoise();
        System.out.println(dog);

        Dog dog2 = new Dog(0.2, "Pug", 12);
        dog2.move(9);
        dog2.makeNoise();
        dog2.grabToy();
        System.out.println(dog2);


    }
}
