package com.masterclass.newcontent.section11.interfaceDefaultMeth;

public class Main implements InterfaceA, InterfaceB {

    public static void main(String[] args) {

        Main main = new Main();
        main.printSomething();

    }

    /*
    * We have to implement the printSomething() method because of the Diamond problem in java.*/
    @Override
    public void printSomething() {

        //Option 1 -> Provide our own implementation:
        System.out.println("I am inside Main class");

        //Option 2 -> Use existing implementation from InterfaceA or InterfaceB:
        InterfaceA.super.printSomething();
        InterfaceB.super.printSomething();
    }


}
